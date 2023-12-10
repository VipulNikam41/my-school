package com.myschool.domain.dto;

import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Data
public class InstituteResponse {
    private ProfilePictureResponse profilePictureResponse;
    private String name;
    private String userName;
    private String motto;
    private String about;
    private Date establishedOn;
    private UUID ownerId;
    private ContactResponse contact;
    private UUID homeBranchId;
}
