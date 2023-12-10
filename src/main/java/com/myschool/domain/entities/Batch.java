package com.myschool.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class Batch extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @JoinColumn(name = "profile_picture_id")
    @OneToOne
    private ProfilePicture profilePicture;

    private String name;

    private String description;

    private UUID instituteId;

    private int batchSize;

    @Column(nullable = false, scale = 2)
    private BigDecimal fees;
}