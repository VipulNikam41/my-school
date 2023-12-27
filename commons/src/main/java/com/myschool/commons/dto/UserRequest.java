package com.myschool.commons.dto;

import com.myschool.commons.constants.UserRole;
import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private ProfilePictureRequest profilePicture;
    private ContactRequest contact;
    private String dateOfBirth;
    private UserRole primaryGoal;
}