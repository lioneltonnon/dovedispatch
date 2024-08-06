package com.lioneltonnon.dovedispatch.receivers;

import com.lioneltonnon.dovedispatch.config.ApplicationProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiverQueueService implements IReceiver {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ReceiverQueueService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public String receive() {
        String message = (String) rabbitTemplate.receiveAndConvert("defaultQueue");
        return message != null ? message : "No message received";
    }
}