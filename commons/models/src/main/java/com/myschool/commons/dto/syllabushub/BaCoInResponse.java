package com.myschool.commons.dto.syllabushub;

import com.myschool.commons.dto.BatchResponse;
import com.myschool.commons.dto.ContactResponse;
import com.myschool.commons.dto.InstructorResponse;
import lombok.Data;

@Data
public class BaCoInResponse {
    private BatchResponse batch;
    private ContactResponse course;
    private InstructorResponse instructor;
}
