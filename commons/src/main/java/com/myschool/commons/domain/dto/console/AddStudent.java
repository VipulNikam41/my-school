package com.myschool.commons.domain.dto.console;

import com.myschool.commons.domain.dto.ContactRequest;
import com.myschool.commons.domain.dto.ProfilePictureRequest;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class AddStudent {
    private ProfilePictureRequest profilePicture;
    private String name;
    private UUID batchId;
    private ContactRequest contact;
    private String dateOfBirth;
    private BigDecimal discountedFees;
}
