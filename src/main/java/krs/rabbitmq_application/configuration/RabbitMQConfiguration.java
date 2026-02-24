package krs.rabbitmq_application.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    public static final String QUEUE = "rabbitmq_queue";
    public static final String EXCHANGE = "rabbitmq_exchange";
    public static final String ROUTING_KEY = "rabbitmq_routing_key";

    // Creating the Queue that will store messages
    @Bean
    public Queue queue() {
        return new Queue(QUEUE, true);
    }

    // Creating the Exchange of the type Direct
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE);
    }

    // Binding the queue to the exchange using the routing key
    @Bean
    public Binding binding(Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue)
                .to(directExchange)
                .with(ROUTING_KEY);
    }

    // Allowing JSON to be converted
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // Setting RabbitTemplate to use the converter
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }


}
