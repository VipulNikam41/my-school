package com.myschool;

import com.myschool.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAutoConfiguration
@Import(ApplicationConfig.class)
public class MySchoolApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySchoolApplication.class, args);
    }
}