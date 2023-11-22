package com.myschool.domain.dto;

import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Data
public class InstituteRequest {
    private String name;
    private String userName;
    private String motto;
    private String about;
    private Date establishedOn;
    private UUID ownerUserId;
    private ContactRequest contact;
}
