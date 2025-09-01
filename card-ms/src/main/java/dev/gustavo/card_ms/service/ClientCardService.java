package dev.gustavo.card_ms.service;

import dev.gustavo.card_ms.domain.ClientCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCardService {

    private final ClientCardService clientCardService;

    public List<ClientCard> findByCode(String cpf) {
        return clientCardService.findByCode(cpf);
    }

}
