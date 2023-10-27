package com.myschool.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class StudentCourses extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID studentId;

    private UUID courseId;

    private String discountedFees;
}
