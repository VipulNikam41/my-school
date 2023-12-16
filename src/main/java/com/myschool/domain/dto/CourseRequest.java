package com.myschool.domain.dto;

import lombok.Data;

@Data
public class CourseRequest {
    private ProfilePictureRequest profilePicture;
    private String name;
    private String description;
    private int categoryId;
}
