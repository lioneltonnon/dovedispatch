package com.lioneltonnon.dovedispatch.senders;

import com.lioneltonnon.dovedispatch.role.RoleExecutor;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

// Executes logic for sending messages and manages the sending process
@Component
public class SenderExecutor implements RoleExecutor, ISender {

    private final SenderQueueService senderQueueService;

    @Autowired
    public SenderExecutor(SenderQueueService senderQueueService) {
        this.senderQueueService = senderQueueService;
    }

    @Override
    public void execute() {
        System.out.println("Starting producer...");
        send("Hello from producer");
    }

    @Override
    public void send(String message) {
        senderQueueService.send(message);
    }
}
