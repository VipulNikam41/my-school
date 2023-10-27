package com.myschool.domain.dto;

import com.myschool.domain.entities.Contact;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Data
public class InstituteDTO {
    private String name;
    private String userName;
    private String motto;
    private String about;
    private Date establishedOn;
    private UUID ownerUserId;
    private Contact contact;
}
