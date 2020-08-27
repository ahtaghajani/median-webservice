package com.rapidminer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MedianApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MedianApplication.class, args);

    }

}
