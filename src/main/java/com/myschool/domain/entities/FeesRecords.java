package com.myschool.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class FeesRecords extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID instituteId;

    private UUID cashierId;

    private UUID studentId;

    @Column(nullable = false, scale = 2)
    private BigDecimal amount;
}
