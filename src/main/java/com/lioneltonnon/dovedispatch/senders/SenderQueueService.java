package com.lioneltonnon.dovedispatch.senders;

import com.lioneltonnon.dovedispatch.config.ApplicationProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderQueueService {

    private final RabbitTemplate rabbitTemplate;
    private final ApplicationProperties properties;

    @Autowired
    public SenderQueueService(RabbitTemplate rabbitTemplate, ApplicationProperties properties) {
        this.rabbitTemplate = rabbitTemplate;
        this.properties = properties;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(properties.getRabbitmq().getQueue(), message);
        System.out.println("Sent message: " + message);
    }
}
