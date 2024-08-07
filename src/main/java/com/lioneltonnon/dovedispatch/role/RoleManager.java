package com.lioneltonnon.dovedispatch.role;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
