package dev.gustavo.client_ms.service;

import dev.gustavo.client_ms.domain.Client;
import dev.gustavo.client_ms.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    @Transactional
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> getByCode(String code) {
        return clientRepository.findByCode(code);
    }

}
