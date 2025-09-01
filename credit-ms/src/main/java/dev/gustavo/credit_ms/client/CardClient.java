package dev.gustavo.credit_ms.client;

import dev.gustavo.credit_ms.controller.dto.ClientCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "card-ms")
public interface CardClient {

    @GetMapping(value = "/card", params = "code")
    ResponseEntity<List<ClientCard>> getCards(@RequestParam("code") String code);

}
