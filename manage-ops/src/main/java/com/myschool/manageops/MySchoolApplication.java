package com.myschool.manageops;

import com.myschool.manageops.setup.config.ApplicationConfig;
import com.myschool.manageops.setup.config.SecurityConfig;
import com.myschool.manageops.setup.config.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@Import({ApplicationConfig.class, SecurityConfig.class, WebConfiguration.class})
@EntityScan(value = {"com.myschool.commons.entities", "com.myschool.manageops.domain.entities"})
@EnableJpaRepositories(value = {"com.myschool.commons.repository", "com.myschool.manageops.domain.repository"})
public class MySchoolApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySchoolApplication.class, args);
    }
}