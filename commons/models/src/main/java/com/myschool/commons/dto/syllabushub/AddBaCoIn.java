package com.myschool.commons.dto.syllabushub;

import com.myschool.commons.dto.StatefulRequest;
import lombok.Data;

import java.util.UUID;

@Data
public class AddBaCoIn extends StatefulRequest {
    private UUID batchId;
    private UUID courseId;
    private UUID instructorId;
}
