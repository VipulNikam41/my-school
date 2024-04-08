package com.myschool.commons.dto.syllabushub;

import com.myschool.commons.entities.BaseEntity;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class LectureRequest extends BaseEntity {
    private UUID baCoInId;
    private String name;
    private String description;
    private Date startTime;
    private Date endTime;
}
