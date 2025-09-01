package dev.gustavo.credit_ms.controller;

import dev.gustavo.credit_ms.controller.dto.ClientSituationDTO;
import dev.gustavo.credit_ms.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/credit-analysis")
public class CreditController {

    private final CreditService creditService;

    @GetMapping
    public String status() {
        return "ok";
    }

    // /credit=analysis/client-situation?code=1234567890
    @GetMapping(value = "/client-situation", params = "code")
    public ResponseEntity<ClientSituationDTO> clientSituation(@RequestParam String code) {
        return ResponseEntity.ok().body(creditService.clientSituation(code));
    }
}
