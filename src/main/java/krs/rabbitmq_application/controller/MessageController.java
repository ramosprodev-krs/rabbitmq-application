package krs.rabbitmq_application.controller;

import krs.rabbitmq_application.dto.MessageDTO;
import krs.rabbitmq_application.producer.MessageProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    // Manually injecting dependency
    private final MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping
    public MessageDTO sendMessage(@RequestBody MessageDTO messageDTO) {
        this.messageProducer.send(messageDTO);
        return messageDTO;
    }
}
