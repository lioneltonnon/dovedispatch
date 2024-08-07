package com.lioneltonnon.dovedispatch.receivers;

import com.lioneltonnon.dovedispatch.role.RoleExecutor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ReceiverExecutor implements RoleExecutor {

    private final IReceiver receiverService;

    @Autowired
    public ReceiverExecutor(IReceiver receiverService) {
        this.receiverService = receiverService;
    }

    // Execute method for RoleExecutor interface
    @Override
    public void execute() {
        System.out.println("Starting consumer...");
    }

    // Method to listen for messages
    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receiveMessage(String message) {
        System.out.println("Receiver Received message: " + message);
        // Add further processing logic if needed
    }
}