package com.myscool.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Entity
@Data
public class InstituteBranch extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID instituteId;

    private String name;

    private String about;

    private Date establishedOn;

    @JoinColumn(name = "contact_id")
    @OneToOne
    private Contact contact;

    private boolean isMainBranch;
}
