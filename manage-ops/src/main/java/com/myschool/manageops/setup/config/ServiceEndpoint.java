package com.myschool.manageops.setup.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class ServiceEndpoint {
    @Value("${service.endpoint.payments}")
    private String payments;

    @Value("${service.endpoint.syllabus-hub}")
    private String syllabusHub;
}
