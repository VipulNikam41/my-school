package com.myschool.commons.dto.console;

import com.myschool.commons.dto.ProfilePictureRequest;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BatchRequest {
    private ProfilePictureRequest profilePicture;
    private String name;
    private String description;
    private int batchSize;
    private BigDecimal fees;
}
