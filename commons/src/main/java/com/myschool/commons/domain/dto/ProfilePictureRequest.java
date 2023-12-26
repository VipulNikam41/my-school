package com.myschool.commons.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfilePictureRequest {
    private String color;
    private String imageLink;
}
