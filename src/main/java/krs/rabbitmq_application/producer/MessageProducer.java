package krs.rabbitmq_application.producer;

import krs.rabbitmq_application.configuration.RabbitMQConfiguration;
import krs.rabbitmq_application.dto.MessageDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    // Manually injecting dependencies
    private final RabbitTemplate rabbitTemplate;

    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // Creating send method with rabbitTemplate
    public void send(MessageDTO messageDTO) {
        this.rabbitTemplate.convertAndSend(
                RabbitMQConfiguration.EXCHANGE,
                RabbitMQConfiguration.ROUTING_KEY,
                messageDTO
        );

        System.out.println("The JSON message has been sent: " + messageDTO);
    }
}
