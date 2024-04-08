package com.myschool.commons.dto.syllabushub;

import lombok.Data;

import java.util.UUID;

@Data
public class ExamRequest {
    private LectureRequest lecture;
    private float marks;
    private UUID invigilatorId;
}
