package com.palvair.circuit.breaker.bookstore;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BookStoreApplication {

    private static final String THE_SOFTWARE_CRAFTSMAN = "The Software Craftsman";

    @RequestMapping(value = "/recommended")
    public String readingList() {
        return THE_SOFTWARE_CRAFTSMAN;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(BookStoreApplication.class)
                .application()
                .run(args);
    }
}
