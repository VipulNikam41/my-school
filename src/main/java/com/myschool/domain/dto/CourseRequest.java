package com.myschool.domain.dto;

import lombok.Data;

@Data
public class CourseRequest {
    private String name;
    private String description;
    private int categoryId;
    private int batchSize;
    private int instructorId;
    private int fees;
}
