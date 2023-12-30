package com.myschool.commons.dto;

import lombok.Data;

@Data
public class BaCoInResponse {
    private BatchResponse batch;
    private ContactResponse course;
    private InstructorResponse instructor;
}
