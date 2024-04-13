package com.myschool.commons.dto;

import com.myschool.commons.dto.support.BaseResponse;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AuthTokenResponse extends BaseResponse {
    private String authType;
    private UUID userId;
    private String authToken;
    private String expiryTime;
}
