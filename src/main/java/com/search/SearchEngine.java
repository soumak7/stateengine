package com.search;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchEngine {

    private static final Logger logger = LogManager.getLogger(SearchEngine.class);

    public static void main(String[] args) {
        SpringApplication.run(SearchEngine.class, args);
    }

}
