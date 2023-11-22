package com.myschool.domain.entities;

import com.myschool.constants.UserRole;
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

    @Enumerated(EnumType.STRING)
    private UserRole primaryGoal;
}
