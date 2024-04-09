package com.myschool.syllabushub.domain.entities;

import com.myschool.commons.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Exam extends BaseEntity {
    @Id
    private UUID id;

    @MapsId
    @JoinColumn(name = "lecture_id")
    @OneToOne
    private Lecture lecture;

    private float marks;

    private UUID invigilatorId;
}
