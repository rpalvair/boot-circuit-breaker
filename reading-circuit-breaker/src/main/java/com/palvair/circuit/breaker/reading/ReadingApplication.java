package com.palvair.circuit.breaker.reading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
@EnableCircuitBreaker
public class ReadingApplication {

    @Autowired
    private BookService bookService;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @RequestMapping("/to-read")
    public String readingList() {
        return bookService.readingList();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ReadingApplication.class)
                .application()
                .run(args);
    }
}
