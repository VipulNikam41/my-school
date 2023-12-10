package com.myschool.domain.dto;

import com.myschool.constants.UserRole;
import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private ProfilePictureRequest profilePicture;
    private ContactRequest contact;
    private String dateOfBirth;
    private UserRole primaryGoal;
}