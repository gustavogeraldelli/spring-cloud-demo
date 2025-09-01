package dev.gustavo.credit_ms.controller.dto;

import java.math.BigDecimal;

public record IssueCard(
        Long cardId,
        String code,
        BigDecimal limit
) {
}
