package com.myschool.commons.dto;

import com.myschool.commons.dto.support.BaseResponse;
import com.myschool.constants.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse extends BaseResponse {
    private UUID id;
    private ProfilePictureResponse profilePicture;
    private String name;
    private ContactResponse contact;
    private String dateOfBirth;
    private UserRole primaryGoal;
}
