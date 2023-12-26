package com.myschool.commons.domain.dto.console;

import com.myschool.commons.domain.dto.ContactRequest;
import com.myschool.commons.domain.dto.ProfilePictureRequest;
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
