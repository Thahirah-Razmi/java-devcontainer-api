package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RestController
    static class HelloController {

        @GetMapping("/api/hello")
        public String hello() {
            return "Hello from my Java Dev Container!";
        }

        @Value("${spring.application.name}")
        private String applicationName;

        @GetMapping("/api/info")
        public String info() {
            return applicationName + " - Java 21 - Spring Boot";
        }
    }
}