package com.myschool.commons.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Indexed;

@Data
@Indexed
public class CourseRequest {
    private ProfilePictureRequest profilePicture;
    private String name;
    private String description;
    private int categoryId;
}
