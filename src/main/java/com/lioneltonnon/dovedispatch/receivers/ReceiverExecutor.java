package com.lioneltonnon.dovedispatch.receivers;

import com.lioneltonnon.dovedispatch.role.RoleExecutor;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ReceiverExecutor implements RoleExecutor, IReceiver {

    private final ReceiverQueueService receiverQueueService;

    @Autowired
    public ReceiverExecutor(ReceiverQueueService receiverQueueService) {
        this.receiverQueueService = receiverQueueService;
    }

    @Override
    public void execute() {
        System.out.println("Starting consumer...");
        receive();
    }

    @Override
    public void receive() {
        String message = receiverQueueService.receiveMessage();
        System.out.println("Received message: " + message);
    }
}
