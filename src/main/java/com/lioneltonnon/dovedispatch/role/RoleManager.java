package com.lioneltonnon.dovedispatch.role;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// Manages roles by setting app role for parallel execution of multiple app instances
// Should probably be refactored so that the Main (DovedispatchApplication) doesn't use this but the interface...
@Component
public class RoleManager {

    @Value("${app.role}")
    private String role;

    public String getRole() {
        return role;
    }

    @PostConstruct
    public void init() {
        System.out.println("Loaded role from properties: " + role);
    }
}
