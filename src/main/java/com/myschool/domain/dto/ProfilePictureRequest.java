package com.myschool.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProfilePictureRequest {
    private String color;
    private String imageLink;
}
