package com.lioneltonnon.dovedispatch.senders;

import com.lioneltonnon.dovedispatch.config.ApplicationProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderQueueService implements ISender {

    private final RabbitTemplate rabbitTemplate;
    private final String exchangeName;
    private final String routingKey;

    @Autowired
    public SenderQueueService(RabbitTemplate rabbitTemplate, ApplicationProperties customProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchangeName = customProperties.getExchange();
        this.routingKey = customProperties.getRoutingKey();
        System.out.println("Initialized SenderQueueService with Exchange: " + this.exchangeName + ", Routing Key: " + this.routingKey);
    }

    @Override
    public void send(String message) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
        System.out.println("Sent message: " + message);
    }
}
