package com.myschool.commons.dto;

import com.myschool.constants.UserRole;
import lombok.Data;

@Data
public class UserRequest extends StatefulRequest {
    private String name;
    private ProfilePictureRequest profilePicture;
    private ContactRequest contact;
    private String dateOfBirth;
    private UserRole primaryGoal;
}