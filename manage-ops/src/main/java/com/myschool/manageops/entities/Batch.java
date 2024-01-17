package com.myschool.manageops.entities;

import com.myschool.commons.entities.BaseEntity;
import com.myschool.commons.entities.ProfilePicture;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class Batch extends BaseEntity {
    public static final String ENTITY = "Batch";

    @Id
    @GeneratedValue
    private UUID id;

    @JoinColumn(name = "profile_picture_id")
    @OneToOne
    private ProfilePicture profilePicture;

    private String name;

    private String description;

    private UUID instituteId;

    private Integer batchSize;

    @Column(nullable = false, scale = 2)
    private BigDecimal fees;
}