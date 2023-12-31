package com.myschool.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(value = {"com.myschool.commons.entities", "com.myschool.dashboard.entities"})
public class Dashboard {
    public static void main(String[] args) {
        SpringApplication.run(Dashboard.class, args);
    }
}