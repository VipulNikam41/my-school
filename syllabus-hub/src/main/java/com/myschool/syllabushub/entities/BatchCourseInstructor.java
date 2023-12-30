package com.myschool.syllabushub.entities;

import com.myschool.commons.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class BatchCourseInstructor extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID batchId;

    private UUID courseId;

    private UUID instructorId;
}
