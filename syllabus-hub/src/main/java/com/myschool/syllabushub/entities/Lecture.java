package com.myschool.syllabushub.entities;

import com.myschool.commons.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Lecture extends BaseEntity {
    public static final String ENTITY = "Lecture";

    @Id
    @GeneratedValue
    private UUID id;

    @JoinColumn(name = "bacoin_id")
    @OneToOne
    private BatchCourseInstructor baCoIn;

    private String name;

    private String description;

    private Date startTime;

    private Date endTime;

    private boolean recurring;
}
