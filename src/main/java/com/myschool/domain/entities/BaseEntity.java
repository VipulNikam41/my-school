package com.myscool.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@MappedSuperclass
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseEntity {
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;

    @PrePersist
    protected void onCreate() {
        createdOn = new Date();
        updatedOn = createdOn;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedOn = new Date();
    }
}
