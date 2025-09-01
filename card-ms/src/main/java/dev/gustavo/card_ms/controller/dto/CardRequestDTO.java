package dev.gustavo.card_ms.controller.dto;

import dev.gustavo.card_ms.domain.Card;
import dev.gustavo.card_ms.domain.CardNetwork;

import java.math.BigDecimal;

public record CardRequestDTO(
        String name,
        CardNetwork network,
        BigDecimal income,
        BigDecimal limit
) {

    public Card toEntity() {
        return new Card(name, network, income, limit);
    }

}
