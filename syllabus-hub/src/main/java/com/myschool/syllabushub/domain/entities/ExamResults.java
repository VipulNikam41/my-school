package com.myschool.syllabushub.domain.entities;

import com.myschool.commons.entities.BaseEntity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class ExamResults extends BaseEntity {
    @EmbeddedId
    private StudentLectureKey id;

    private UUID staffId;

    private float marks;

    private String remark;
}
