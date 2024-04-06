package com.myschool.commons.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AuthTokenResponse {
    private String authType;
    private UUID userId;
    private String authToken;
    private String expiryTime;
}
