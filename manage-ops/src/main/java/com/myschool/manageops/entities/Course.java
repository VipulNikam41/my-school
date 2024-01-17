package com.myschool.manageops.entities;

import com.myschool.commons.entities.BaseEntity;
import com.myschool.commons.entities.ProfilePicture;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "courses")
public class Course extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @JoinColumn(name = "profile_picture_id")
    @OneToOne
    private ProfilePicture profilePicture;

    private String name;

    private String description;

    private UUID instituteId;

    private int categoryId;
}
