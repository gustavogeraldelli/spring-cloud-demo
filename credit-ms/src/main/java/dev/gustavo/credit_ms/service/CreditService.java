package dev.gustavo.credit_ms.service;

import dev.gustavo.credit_ms.client.CardClient;
import dev.gustavo.credit_ms.client.ClientClient;
import dev.gustavo.credit_ms.controller.dto.ClientCard;
import dev.gustavo.credit_ms.controller.dto.ClientData;
import dev.gustavo.credit_ms.controller.dto.ClientSituationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditService {

    private final ClientClient clientClient;
    private final CardClient cardClient;

    public ClientSituationDTO clientSituation(String code) {
        // get client data from client-ms (GET /client?cpf=)
        ResponseEntity<ClientData> client = clientClient.getClientByCode(code);
        // get card data from card-ms (GET /card?cpf=)
        //ResponseEntity<List<ClientCard>> clientSituation = cardClient.getCards(code);

        return new ClientSituationDTO(client.getBody(), null);
    }

}
