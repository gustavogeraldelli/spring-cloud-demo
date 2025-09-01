package dev.gustavo.card_ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ClientCard extends JpaRepository<ClientCard, Long> {

    List<ClientCard> findBYCode(String cpf);

}
