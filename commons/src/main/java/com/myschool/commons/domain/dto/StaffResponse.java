package com.myschool.commons.domain.dto;

import com.myschool.commons.constants.Privilege;
import com.myschool.commons.constants.StaffRole;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class StaffResponse {
    private UUID id;
    private ProfilePictureResponse profilePicture;
    private String name;
    private ContactResponse contact;
    private String dateOfBirth;
    private List<Privilege> privileges;
    private StaffRole primaryGoal;
}
