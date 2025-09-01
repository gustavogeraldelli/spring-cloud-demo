package dev.gustavo.credit_ms.controller.dto;

import java.util.List;

public record ClientSituationDTO(
        ClientDate client,
        List<ClientCard> cards
) {
}
