package com.myscool.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Entity
@Data
public class Institute extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String userName;

    private String motto;

    private String about;

    private Date establishedOn;

    private UUID ownerUserId;

    @JoinColumn(name = "contact_id")
    @OneToOne
    private Contact contact;
}
