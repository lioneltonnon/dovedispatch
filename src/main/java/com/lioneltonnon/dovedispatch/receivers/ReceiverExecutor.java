package com.lioneltonnon.dovedispatch.receivers;

import com.lioneltonnon.dovedispatch.role.RoleExecutor;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ReceiverExecutor implements RoleExecutor, IReceiver {

    private final IReceiver receiverService;

    @Autowired
    public ReceiverExecutor(IReceiver receiverService) {
        this.receiverService = receiverService;
    }

    // Execute method for RoleExecutor interface
    @Override
    public void execute() {
        System.out.println("Starting consumer...");

        // Start listening for messages
        listenForMessages();
    }

    // Method to listen for messages
    private void listenForMessages() {
        while (true) { // Simple loop to simulate continuous listening
            String message = receiverService.receive();
            if (!"No message received".equals(message)) {
                System.out.println("Received message: " + message);
            }
            try {
                Thread.sleep(1000); // Sleep to simulate delay and avoid busy-waiting
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    // Method to receive a single message - for IReceiver interface
    @Override
    public String receive() {
        return receiverService.receive();
    }
}
