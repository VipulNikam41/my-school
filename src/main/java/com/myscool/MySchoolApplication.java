package com.myscool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class MySchoolApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySchoolApplication.class, args);
    }
}