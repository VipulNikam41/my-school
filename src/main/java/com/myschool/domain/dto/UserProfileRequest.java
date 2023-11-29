package com.myschool.domain.dto;

import com.myschool.constants.UserRole;
import lombok.Data;

@Data
public class UserProfileRequest {
    private String name;
    private ContactRequest contact;
    private String dateOfBirth;
    private UserRole primaryGoal;
}