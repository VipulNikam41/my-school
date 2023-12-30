package com.myschool.syllabushub.entities;

import com.myschool.commons.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class ExamResults extends BaseEntity {
    @Id
    private UUID lectureId;
    @Id
    private UUID studentId;

    private UUID staffId;

    private float marks;

    private String remark;
}
