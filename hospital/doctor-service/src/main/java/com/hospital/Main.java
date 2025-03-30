package com.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hospital.*"})
@EntityScan(basePackages = {"com.hospital.*"})
@EnableMongoRepositories(basePackages = {"com.hospital.*"})

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}