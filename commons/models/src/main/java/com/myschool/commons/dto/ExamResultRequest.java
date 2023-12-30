package com.myschool.commons.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ExamResultRequest {
    private UUID studentId;
}
