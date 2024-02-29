package com.myschool.manageops.domain.entities;

import com.myschool.commons.entities.BaseEntity;
import com.myschool.commons.entities.Contact;
import com.myschool.commons.entities.ProfilePicture;
import com.myschool.constants.UserRole;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @JoinColumn(name = "profile_picture_id")
    @OneToOne
    private ProfilePicture profilePicture;

    private String name;

    @JoinColumn(name = "contact_id")
    @OneToOne
    private Contact contact;

    private String dateOfBirth;

    @Enumerated(EnumType.STRING)
    private UserRole primaryGoal;
}
