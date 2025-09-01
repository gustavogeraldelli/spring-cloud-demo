package dev.gustavo.card_ms.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class ClientCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientCode;
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;
    private BigDecimal limit;

}
