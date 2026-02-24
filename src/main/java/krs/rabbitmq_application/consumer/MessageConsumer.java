package krs.rabbitmq_application.consumer;

import krs.rabbitmq_application.configuration.RabbitMQConfiguration;
import krs.rabbitmq_application.dto.MessageDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    // Creating message receiving method
    @RabbitListener(queues = RabbitMQConfiguration.QUEUE)
    public void receiveMessage(MessageDTO messageDTO) {
        System.out.println("JSON message has been received: " + messageDTO);
    }

}
