package com.myschool.commons.domain.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CourseResponse {
    private UUID id;
    private ProfilePictureResponse profilePicture;
    private String name;
    private String description;
    private UUID instituteId;
    private int categoryId;
}
