package dev.gustavo.card_ms.controller.dto;

import dev.gustavo.card_ms.domain.CardNetwork;
import dev.gustavo.card_ms.domain.ClientCard;

import java.math.BigDecimal;

public record ClientCardsResponseDTO(
        String name,
        CardNetwork network,
        BigDecimal limit
) {

    public static ClientCardsResponseDTO of(ClientCard clientCard) {
        return new ClientCardsResponseDTO(clientCard.getCard().getName(),
                clientCard.getCard().getNetwork(), clientCard.getLimit());
    }

}
