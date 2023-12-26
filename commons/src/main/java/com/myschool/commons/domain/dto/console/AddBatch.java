package com.myschool.commons.domain.dto.console;

import com.myschool.commons.domain.dto.ProfilePictureRequest;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AddBatch {
    private ProfilePictureRequest profilePicture;
    private String name;
    private String description;
    private int batchSize;
    private BigDecimal fees;
}
