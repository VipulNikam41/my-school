package com.myschool.domain.dto;

import com.myschool.constants.UserRole;
import com.myschool.domain.entities.Contact;
import lombok.Data;

@Data
public class UserProfileRequest {
    private String name;
    private Contact contact;
    private String dateOfBirth;
    private UserRole primaryGoal;
}