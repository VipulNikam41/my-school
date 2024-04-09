package com.myschool.commons.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class StatefulRequest {
    private UUID currentLoggedInUser;
}
