package dev.gustavo.credit_ms.service;

import dev.gustavo.credit_ms.client.CardClient;
import dev.gustavo.credit_ms.client.ClientClient;
import dev.gustavo.credit_ms.controller.dto.*;
import dev.gustavo.credit_ms.producer.CardIssuanceProducer;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditService {

    private final ClientClient clientClient;
    private final CardClient cardClient;
    private final CardIssuanceProducer cardIssuanceProducer;

    public ClientSituationDTO clientSituation(String code) {
        // get client data from client-ms (GET /clients?cpde=)
        // get card data from card-ms (GET /cards?code=)
        try {
            ResponseEntity<ClientData> client = clientClient.getClientByCode(code);
            ResponseEntity<List<BasicCardData>> clientSituation = cardClient.getCards(code);
            return new ClientSituationDTO(client.getBody(), clientSituation.getBody());
        }
        catch (FeignException.FeignClientException e) {
            int status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status)
                // throw custom exception and treat it to give a better response
                return new ClientSituationDTO(null, null);
            // same here
            return new ClientSituationDTO(null, null);
        }
    }

    public EvaluatedClient evaluate(String code, Long income) {
        try {
            // client data (age is used on this business logic)
            ResponseEntity<ClientData> client = clientClient.getClientByCode(code);
            // cards that accepts up to that income
            ResponseEntity<List<CardData>> approvedCards = cardClient.getCardsByIncome(income);

            // raising card limit using client's age
            var mappedApprovedCards = approvedCards.getBody().stream().map(card -> {
                BigDecimal ageB = BigDecimal.valueOf(client.getBody().age());
                var limit = ageB.divide(BigDecimal.valueOf(10)).multiply((card.limit()));
                BasicCardData approved = new BasicCardData(card.name(), card.network(), limit);
                return approved;
            }).toList();
            return new EvaluatedClient(mappedApprovedCards);
        }
        catch (FeignException.FeignClientException e) {
            int status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status)
                // throw custom exception and treat it to give a better response
                return new EvaluatedClient(null);
            // same here
            return new EvaluatedClient(null);
        }
    }

    public IssueCardProtocol issueCard(IssueCard issueCard) {
        cardIssuanceProducer.send(issueCard);
        return new IssueCardProtocol(UUID.randomUUID().toString());
    }

}
