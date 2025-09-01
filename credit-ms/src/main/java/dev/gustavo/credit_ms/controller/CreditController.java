package dev.gustavo.credit_ms.controller;

import dev.gustavo.credit_ms.controller.dto.*;
import dev.gustavo.credit_ms.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/credit-analysis")
public class CreditController {

    private final CreditService creditService;

    @GetMapping
    public String status() {
        return "ok";
    }

    // /credit-analysis/client-situation?code=1234567890
    @GetMapping(value = "/client-situation", params = "code")
    public ResponseEntity<ClientSituationDTO> clientSituation(@RequestParam String code) {
        return ResponseEntity.ok().body(creditService.clientSituation(code));
    }

    @PostMapping
    public ResponseEntity<EvaluatedClient> evaluate(@RequestBody EvaluationData data) {
        return ResponseEntity.ok(creditService.evaluate(data.code(), data.income()));
    }

    @PostMapping("/issue-card")
    public ResponseEntity<IssueCardProtocol> issueCard(@RequestBody IssueCard issueCard) {
        return ResponseEntity.ok().body(creditService.issueCard(issueCard));
    }
}
