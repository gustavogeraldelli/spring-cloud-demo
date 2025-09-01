package dev.gustavo.card_ms.repository;

import dev.gustavo.card_ms.domain.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {

    List<ClientCard> findByClientCode(String code);

}
