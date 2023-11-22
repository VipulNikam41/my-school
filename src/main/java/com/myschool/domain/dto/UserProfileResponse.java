package com.myschool.domain.dto;

import com.myschool.constants.UserRole;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserProfileResponse {
    private UUID id;
    private String name;
    private ContactResponse contact;
    private String dateOfBirth;
    private UserRole primaryGoal;
}
