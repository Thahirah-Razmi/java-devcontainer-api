package com.example.demo;

import com.example.demo.config.AppConfig;
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

        private final AppConfig appConfig;

        HelloController(AppConfig appConfig) {
            this.appConfig = appConfig;
        }

        @GetMapping("/api/hello")
        public String hello() {
            return appConfig.getGreeting();
        }

        @Value("${spring.application.name}")
        private String applicationName;

        @GetMapping("/api/info")
        public String info() {
            return applicationName + " - Java 21 - Spring Boot";
        }
    }
}