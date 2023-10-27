package com.myschool.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class UserProfile extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @JoinColumn(name = "contact_id")
    @OneToOne
    private Contact contact;

    private String dateOfBirth;

    private String primaryGoal;
}
