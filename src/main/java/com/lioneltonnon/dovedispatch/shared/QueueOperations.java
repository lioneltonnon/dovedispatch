package com.lioneltonnon.dovedispatch.shared;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueOperations {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public QueueOperations(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String queueName, String message) {
        rabbitTemplate.convertAndSend(queueName, message);
    }

    public String receiveMessage(String queueName) {
        return (String) rabbitTemplate.receiveAndConvert(queueName);
    }
}
