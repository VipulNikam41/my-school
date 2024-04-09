package com.myschool.syllabushub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(value = {"com.myschool.commons.entities", "com.myschool.syllabushub.domain.entities"})
@EnableJpaRepositories(value = {"com.myschool.syllabushub.repository", "com.myschool.syllabushub.domain.repository"})
public class SyllabusHub {
    public static void main(String[] args) {
        SpringApplication.run(SyllabusHub.class, args);
    }
}