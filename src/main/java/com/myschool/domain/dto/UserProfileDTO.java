package com.myscool.domain.dto;

import com.myscool.constants.UserRole;
import com.myscool.domain.entities.Contact;
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