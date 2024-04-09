package com.myschool.commons.dto.syllabushub;

import com.myschool.commons.dto.support.BaseResponse;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class LectureResponse extends BaseResponse {
    private UUID id;
    private BaCoInResponse baCoIn;
    private String name;
    private String description;
    private Date startTime;
    private Date endTime;
    private boolean recurring;
}
