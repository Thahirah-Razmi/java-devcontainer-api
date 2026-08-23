package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final String greeting;

    public AppConfig(
            @Value("${app.greeting:Hello from my Java Dev Container!}") String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }
}