package dev.gustavo.credit_ms.client;

import dev.gustavo.credit_ms.controller.dto.BasicCardData;
import dev.gustavo.credit_ms.controller.dto.CardData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "card-ms")
public interface CardClient {

    @GetMapping(value = "/cards", params = "code")
    ResponseEntity<List<BasicCardData>> getCards(@RequestParam("code") String code);

    @GetMapping("/cards")
    ResponseEntity<List<CardData>> getCardsByIncome(@RequestParam("income") Long income);

}
