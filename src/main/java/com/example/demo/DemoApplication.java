package com.example.demo;

import com.example.demo.config.AppConfig;
import com.example.demo.logging.AppLogger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        private final AppLogger logger;

        HelloController(AppConfig appConfig, AppLogger logger) {
            this.appConfig = appConfig;
            this.logger = logger;
        }

        @GetMapping("/api/hello")
        public String hello() {
            logger.debug(
                    "Greeting requested",
                    "endpoint", "/api/hello");

            String greeting = appConfig.getGreeting();

            logger.info(
                    "Greeting returned",
                    "endpoint", "/api/hello");

            return greeting;
        }

        @Value("${spring.application.name}")
        private String applicationName;

        @GetMapping("/api/info")
        public String info() {
            logger.info(
                    "Application information requested",
                    "endpoint", "/api/info",
                    "application", applicationName);

            return applicationName + " - Java 21 - Spring Boot";
        }

        @GetMapping("/api/failure")
        public ResponseEntity<String> failure() {
            try {
                throw new IllegalStateException("Simulated configuration failure");
            } catch (IllegalStateException exception) {
                logger.error(
                        "Request failed",
                        exception,
                        "endpoint", "/api/failure",
                        "reason", "configuration");

                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("An error occurred while processing the request.");
            }
        }
    }
}