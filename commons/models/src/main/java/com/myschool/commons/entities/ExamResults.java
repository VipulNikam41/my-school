package com.myschool.commons.entities;

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
