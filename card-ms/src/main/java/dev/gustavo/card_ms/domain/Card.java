package dev.gustavo.card_ms.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CardNetwork network;
    private BigDecimal income;
    @Column(name = "card_limit")
    private BigDecimal limit;

    public Card(String name, CardNetwork network, BigDecimal income, BigDecimal limit) {
        this.name = name;
        this.network = network;
        this.income = income;
        this.limit = limit;
    }

}
