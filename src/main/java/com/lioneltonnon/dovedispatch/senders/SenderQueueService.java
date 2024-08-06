package com.lioneltonnon.dovedispatch.senders;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderQueueService implements ISender {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public SenderQueueService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void send(String message) {
        rabbitTemplate.convertAndSend("defaultQueue", message);
        System.out.println("Sent message: " + message);
    }
}
