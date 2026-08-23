package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void helloEndpointReturnsExpectedMessage() {
        String url = "http://localhost:" + port + "/api/hello";

        ResponseEntity<String> response =
                restTemplate.getForEntity(url, String.class);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(
                "Hello from my Java Dev Container!",
                response.getBody());
                response.getBody()
        );
    }

    @Test
    void infoEndpointReturnsExpectedMessage() {
        String url = "http://localhost:" + port + "/api/info";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(
                "java-devcontainer-api - Java 21 - Spring Boot",
                response.getBody());
    }
}
        ResponseEntity<String> response =
                restTemplate.getForEntity(url, String.class);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(
        "java-devcontainer-api - Java 21 - Spring Boot",
        response.getBody()
);
    }
}
