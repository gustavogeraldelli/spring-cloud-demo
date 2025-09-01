package dev.gustavo.card_ms.service;

import dev.gustavo.card_ms.domain.Card;
import dev.gustavo.card_ms.repository.CardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public void create(Card card) {
        cardRepository.save(card);
    }

    public List<Card> findByIncome(Long income) {
        return cardRepository.findByIncomeLessThanEqual(BigDecimal.valueOf(income));
    }

}
