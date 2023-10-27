package com.myschool.domain.dto;

import com.myschool.constants.UserRole;
import com.myschool.domain.entities.Contact;
import lombok.Data;

import java.util.UUID;

@Data
public class UserProfileDTO extends BaseDTO {
    private UUID id;
    private String name;
    private Contact contact;
    private String dateOfBirth;
    private UserRole primaryGoal;
}