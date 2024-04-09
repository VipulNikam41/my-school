package com.myschool.commons.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ExamResultResponse {
    private UUID lectureId;
    private UUID studentId;
    private UUID staffId;
    private float marks;
    private String remark;
}
