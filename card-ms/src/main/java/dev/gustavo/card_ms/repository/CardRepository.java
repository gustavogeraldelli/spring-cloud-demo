package dev.gustavo.card_ms.repository;

import dev.gustavo.card_ms.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByIncomeLessThanEqual(BigDecimal incomeIsLessThan);

}
