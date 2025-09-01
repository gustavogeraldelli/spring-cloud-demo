package dev.gustavo.credit_ms.producer;

import dev.gustavo.credit_ms.controller.dto.IssueCard;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CardIssuanceProducer {

    @Value("${mq.exchanges.fanout}")
    private String exchange;
    private final RabbitTemplate rabbitTemplate;

    public void send(IssueCard issueCard) {
        rabbitTemplate.convertAndSend(exchange, "", issueCard);
    }

}
