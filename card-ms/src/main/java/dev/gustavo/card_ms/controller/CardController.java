package dev.gustavo.card_ms.controller;

import dev.gustavo.card_ms.controller.dto.CardRequestDTO;
import dev.gustavo.card_ms.controller.dto.ClientCardsResponseDTO;
import dev.gustavo.card_ms.domain.Card;
import dev.gustavo.card_ms.service.CardService;
import dev.gustavo.card_ms.service.ClientCardService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;
    private final ClientCardService clientCardService;

    @GetMapping
    public String status() {
        return "Ok";
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CardRequestDTO card) {
        cardService.create(card.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "income") // /cards?income=4500
    public ResponseEntity<List<Card>> findByIncome(@RequestParam Long income) {
        return ResponseEntity.ok(cardService.findByIncome(income));
    }

    @GetMapping(params = "code") // /cards?code=1234657890
    public ResponseEntity<List<ClientCardsResponseDTO>> findByClientCode(@RequestParam String code) {
        var list = clientCardService.findByCode(code).stream().map(ClientCardsResponseDTO::of).toList();
        return ResponseEntity.ok(list);
    }

}
