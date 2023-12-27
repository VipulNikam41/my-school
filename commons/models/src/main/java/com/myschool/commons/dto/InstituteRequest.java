package com.myschool.commons.dto;

import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Data
public class InstituteRequest {
    private ProfilePictureRequest profilePicture;
    private String name;
    private String userName;
    private String motto;
    private String about;
    private Date establishedOn;
    private UUID ownerId;
    private ContactRequest contact;
}
