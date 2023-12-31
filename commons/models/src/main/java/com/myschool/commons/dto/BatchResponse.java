package com.myschool.commons.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class BatchResponse {
    private UUID id;
    private ProfilePictureResponse profilePicture;
    private String name;
    private String description;
    private UUID instituteId;
    private int batchSize;
    private float fees;
}
