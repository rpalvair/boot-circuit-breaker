package com.palvair.circuit.breaker.reading;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class BookService {

    private static final String CLEAN_CODE = "Clean Code";
    private final RestTemplate restTemplate;

    @Autowired
    public BookService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public String readingList() {
        final URI uri = URI.create("http://localhost:8090/recommended");
        return restTemplate.getForObject(uri, String.class);
    }

    public String reliable() {
        return CLEAN_CODE;
    }
}
