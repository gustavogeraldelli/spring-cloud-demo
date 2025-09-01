package dev.gustavo.card_ms.listener;

import dev.gustavo.card_ms.controller.dto.IssueCard;
import dev.gustavo.card_ms.domain.Card;
import dev.gustavo.card_ms.domain.ClientCard;
import dev.gustavo.card_ms.repository.CardRepository;
import dev.gustavo.card_ms.repository.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardIssuanceListener {

    private final CardRepository cardRepository;
    private final ClientCardRepository clientCardRepository;

    @RabbitListener(queues = "${mq.queues.card-issuance}")
    public void receive(IssueCard cardData) {
        Card card = cardRepository.findById(cardData.cardId()).orElseThrow();
        ClientCard clientCard = new ClientCard();
        clientCard.setCard(card);
        clientCard.setClientCode(cardData.code());
        clientCard.setLimit(cardData.limit());
        clientCardRepository.save(clientCard);
    }

}
