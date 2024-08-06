package com.lioneltonnon.dovedispatch.receivers;

import com.lioneltonnon.dovedispatch.config.ApplicationProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiverQueueService {

    private final RabbitTemplate rabbitTemplate;
    private final ApplicationProperties properties;

    @Autowired
    public ReceiverQueueService(RabbitTemplate rabbitTemplate, ApplicationProperties properties) {
        this.rabbitTemplate = rabbitTemplate;
        this.properties = properties;
    }

    public String receiveMessage() {
        String message = (String) rabbitTemplate.receiveAndConvert(properties.getRabbitmq().getQueue());
        return message != null ? message : "No message received";
    }
}