package com.myschool.domain.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ContactResponse {
    private UUID id;
    private String email;
    private String phoneNumber;
    private String address;
    private String addressPin;
}
