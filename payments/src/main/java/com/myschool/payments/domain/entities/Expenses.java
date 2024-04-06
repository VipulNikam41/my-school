package com.myschool.payments.domain.entities;

import com.myschool.commons.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class Expenses extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID instituteId;

    private UUID staffId;

    @Column(nullable = false, scale = 2)
    private BigDecimal amount;

    private String description;

    private boolean approved;

    private UUID processorStaffId;
}
