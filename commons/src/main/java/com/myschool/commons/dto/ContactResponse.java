package com.myschool.commons.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ContactResponse {
    private UUID id;
    private String email;
    private boolean emailVerified;
    private String phoneNumber;
    private boolean phoneNumberVerified;
    private String address;
    private String addressPin;
}
