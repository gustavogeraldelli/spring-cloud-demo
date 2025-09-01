package dev.gustavo.card_ms.service;

import dev.gustavo.card_ms.domain.ClientCard;
import dev.gustavo.card_ms.repository.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCardService {

    private final ClientCardRepository clientCardRepository;

    public List<ClientCard> findByCode(String code) {
        return clientCardRepository.findByClientCode(code);
    }

}
