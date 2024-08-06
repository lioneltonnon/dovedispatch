package com.lioneltonnon.dovedispatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.lioneltonnon.dovedispatch.role.RoleManager;
import com.lioneltonnon.dovedispatch.senders.SenderExecutor;
import com.lioneltonnon.dovedispatch.receivers.ReceiverExecutor;

@SpringBootApplication
public class DovedispatchApplication {

	public static void main(String[] args) {
		// Start the Spring Boot application
		ApplicationContext context = SpringApplication.run(DovedispatchApplication.class, args);

		// Retrieve the RoleManager bean to determine the role
		RoleManager roleManager = context.getBean(RoleManager.class);

		// Determine the role and execute the appropriate logic
		String role = roleManager.getRole();

		if ("producer".equalsIgnoreCase(role)) {
			SenderExecutor senderExecutor = context.getBean(SenderExecutor.class);
			senderExecutor.execute();
		} else if ("consumer".equalsIgnoreCase(role)) {
			ReceiverExecutor receiverExecutor = context.getBean(ReceiverExecutor.class);
			receiverExecutor.execute();
		} else {
			System.out.println("Invalid role specified. Please set the 'app.role' property to 'producer' or 'consumer'.");
		}
	}
}