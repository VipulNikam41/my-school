package com.myschool.domain.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CourseResponse {
    private UUID id;
    private String name;
    private String description;
    private UUID instituteId;
    private int categoryId;
    private int batchSize;
    private int instructorId;
    private int fees;
}
