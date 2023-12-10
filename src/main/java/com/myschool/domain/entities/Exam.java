package com.myschool.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Exam extends BaseEntity {
    @Id
    @JoinColumn(name = "lecture_id")
    @OneToOne
    private Lecture lecture;

    private float marks;

    private UUID invigilatorId;
}
