package dev.gustavo.client_ms.controller;

import dev.gustavo.client_ms.controller.dto.ClientRequestDTO;
import dev.gustavo.client_ms.domain.Client;
import dev.gustavo.client_ms.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ClientRequestDTO client) {
        clientService.create(client.toEntity());
        URI location = URI.create("/clients/" + client.code());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Client> getByCpf(@PathVariable String code) {
        var optClient = clientService.getByCode(code);
        if (optClient.isEmpty())
            return  ResponseEntity.notFound().build();
        return  ResponseEntity.ok(optClient.get());
    }

}
