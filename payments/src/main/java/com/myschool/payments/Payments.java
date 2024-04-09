package com.myschool.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(value = {"com.myschool.commons.entities", "com.myschool.payments.domain.entities"})
@EnableJpaRepositories(value = {"com.myschool.commons.repository", "com.myschool.payments.domain.repository"})
public class Payments {
    public static void main(String[] args) {
        SpringApplication.run(Payments.class, args);
    }
}