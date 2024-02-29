package com.myschool.commons.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthTokenResponse {
    private String authType;
    private String authToken;
    private String expiryTime;
}
