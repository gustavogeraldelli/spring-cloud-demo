package dev.gustavo.credit_ms.controller.dto;

import java.util.List;

public record ClientSituationDTO(
        ClientData client,
        List<ClientCard> cards
) {
}
