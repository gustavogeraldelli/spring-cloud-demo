package dev.gustavo.credit_ms.service;

import dev.gustavo.credit_ms.controller.dto.ClientSituationDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CreditService {

    public ClientSituationDTO clientSituation(String cpf) {
        // get client data from client-ms (GET /client?cpf=)

        // get card data from card-ms (GET /card?cpf=)
    }

}
