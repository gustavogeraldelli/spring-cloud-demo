package dev.gustavo.client_ms.repository;

import dev.gustavo.client_ms.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByCode(String code);

}
