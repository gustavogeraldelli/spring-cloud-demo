package dev.gustavo.credit_ms.controller.dto;

import java.math.BigDecimal;

public record CardData(
        Long id,
        String name,
        String network,
        BigDecimal limit
) {
}
