package com.myschool.commons.dto.console;

import com.myschool.commons.dto.ContactRequest;
import com.myschool.commons.dto.ProfilePictureRequest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OwnerRegistrationRequest {
    private ProfilePictureRequest profilePicture;
    private String name;
    private ContactRequest contact;
    private String dateOfBirth;
}
