package com.myschool.commons.dto.console;

import com.myschool.commons.dto.ProfilePictureRequest;
import com.myschool.commons.dto.StatefulRequest;
import com.myschool.commons.dto.UserRequest;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class AddStudent extends StatefulRequest {
    private ProfilePictureRequest profilePicture;
    private String name;
    private UUID batchId;
    private UserRequest user;
    private String dateOfBirth;
    private BigDecimal discountedFees;
}
