package com.myschool.commons.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class StudentAttendance extends BaseEntity {
    private UUID staffId;

    @Id
    private UUID lectureId;

    @Id
    private UUID studentId;
}
