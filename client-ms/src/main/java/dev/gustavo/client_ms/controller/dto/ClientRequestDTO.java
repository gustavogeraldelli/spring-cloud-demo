package dev.gustavo.client_ms.controller.dto;

import dev.gustavo.client_ms.domain.Client;

public record ClientRequestDTO(
        String code,
        String name,
        Integer age
) {
    public Client toEntity() {
        return new Client(code, name, age);
    }
}
