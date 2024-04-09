package com.myschool.commons.dto.syllabushub;

import com.myschool.commons.dto.support.BaseResponse;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class AttendanceResponse extends BaseResponse {
    private UUID staffId;
    private UUID studentId;
    private UUID lectureId;
    private Date createdOn;
    private Date updatedOn;
}
