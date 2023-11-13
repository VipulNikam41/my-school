package com.myschool.domain.dto;

import com.myschool.domain.entities.Contact;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserProfileResponse extends BaseResponse {
    private UUID id;
    private String name;
    private Contact contact;
    private String dateOfBirth;
    private String primaryGoal;
}
