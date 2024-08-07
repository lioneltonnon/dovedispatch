package com.lioneltonnon.dovedispatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.lioneltonnon.dovedispatch.role.RoleManager;
import com.lioneltonnon.dovedispatch.senders.SenderExecutor;
import com.lioneltonnon.dovedispatch.receivers.ReceiverExecutor;

// The main entry point for the application, configuring the Spring Boot application.

@SpringBootApplication
public class DovedispatchApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DovedispatchApplication.class, args);

		RoleManager roleManager = context.getBean(RoleManager.class);

		String role = roleManager.getRole();
		System.out.println("Configured role: " + role);

		if ("producer".equalsIgnoreCase(role.trim())) {
			SenderExecutor senderExecutor = context.getBean(SenderExecutor.class);
			senderExecutor.execute();
		} else if ("consumer".equalsIgnoreCase(role.trim())) {
			ReceiverExecutor receiverExecutor = context.getBean(ReceiverExecutor.class);
			receiverExecutor.execute();
		} else {
			System.out.println("Invalid role specified. Please set the 'app.role' property to 'producer' or 'consumer'.");
		}
	}
}