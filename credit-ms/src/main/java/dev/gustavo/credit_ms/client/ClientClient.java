package dev.gustavo.credit_ms.client;

import dev.gustavo.credit_ms.controller.dto.ClientData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-ms", path = "/clients")
public interface ClientClient {

    @GetMapping("/{code}")
    ResponseEntity<ClientData> getClientByCode(@PathVariable String code);

}
