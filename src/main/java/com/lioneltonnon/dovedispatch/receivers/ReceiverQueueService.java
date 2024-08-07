package com.lioneltonnon.dovedispatch.receivers;

import com.lioneltonnon.dovedispatch.config.ApplicationProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiverQueueService implements IReceiver {

    private final RabbitTemplate rabbitTemplate;
    private final String exchangeName;
    private final String routingKey;

    @Autowired
    public ReceiverQueueService(RabbitTemplate rabbitTemplate, ApplicationProperties customProperties) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchangeName = customProperties.getExchange();
        this.routingKey = customProperties.getRoutingKey();
        System.out.println("Initialized SenderQueueService with Exchange: " + this.exchangeName + ", Routing Key: " + this.routingKey);
    }

    @Override
    public String receive() {
        String message = (String) rabbitTemplate.receiveAndConvert("defaultQueue");
        return message != null ? message : "No message received";
    }
}