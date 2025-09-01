package dev.gustavo.credit_ms.controller.dto;

import java.math.BigDecimal;

public record ClientCard(
        String name,
        String network,
        BigDecimal limit
) {
}
