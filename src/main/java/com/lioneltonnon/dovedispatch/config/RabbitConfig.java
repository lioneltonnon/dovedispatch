package com.lioneltonnon.dovedispatch.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;

@Configuration
@EnableRabbit
public class RabbitConfig {

    @Autowired
    private ApplicationProperties customProperties;

    // Check if properties were injected
    @PostConstruct
    public void init() {
        System.out.println("RabbitConfig initialized with:");
        System.out.println("Host: " + customProperties.getHost());
        System.out.println("Port: " + customProperties.getPort());
        System.out.println("Username: " + customProperties.getUsername());
        System.out.println("Virtual Host: " + customProperties.getVirtualHost());
        System.out.println("Exchange: " + customProperties.getExchange());
        System.out.println("Queue: " + customProperties.getQueue());
        System.out.println("Routing Key: " + customProperties.getRoutingKey());
    }


    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost(customProperties.getHost());
        factory.setPort(customProperties.getPort());
        factory.setUsername(customProperties.getUsername());
        factory.setPassword(customProperties.getPassword());
        factory.setVirtualHost(customProperties.getVirtualHost());
        return factory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange(customProperties.getExchange());
        rabbitTemplate.setRoutingKey(customProperties.getRoutingKey());
        return rabbitTemplate;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(CachingConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public Queue queue() {
        return new Queue(customProperties.getQueue(), true);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(customProperties.getExchange(),true,false);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(customProperties.getRoutingKey());
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}