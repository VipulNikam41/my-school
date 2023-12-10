package com.myschool.domain.dto;

import com.myschool.constants.Privilege;
import com.myschool.constants.StaffRole;
import com.myschool.domain.entities.Contact;
import com.myschool.domain.entities.ProfilePicture;
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
