package dev.gustavo.credit_ms.controller.dto;

import java.math.BigDecimal;

public record BasicCardData(
        String name,
        String network,
        BigDecimal limit
) {
}
