package com.myschool.commons.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class BatchStudents extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID batchId;

    private UUID studentId;

    @Column(nullable = false, scale = 2)
    private BigDecimal discountedFees;
}
