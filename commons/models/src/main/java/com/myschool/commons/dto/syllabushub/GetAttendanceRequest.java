package com.myschool.commons.dto.syllabushub;

import com.myschool.commons.dto.StatefulRequest;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class GetAttendanceRequest extends StatefulRequest {
    private UUID studentId;
    private Date from;
    private Date till;
}
