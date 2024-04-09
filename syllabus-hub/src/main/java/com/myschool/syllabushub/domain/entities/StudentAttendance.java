package com.myschool.syllabushub.domain.entities;

import com.myschool.commons.entities.BaseEntity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class StudentAttendance extends BaseEntity {
    public static final String ENTITY = "StudentAttendance";

    private UUID staffId;

    @EmbeddedId
    private StudentLectureKey id;
}
