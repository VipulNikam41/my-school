package com.myschool.commons.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class LoginRequest {
    private String emailId;
    private String phoneNumber;
    private UUID instituteId;
    private String password;
}
