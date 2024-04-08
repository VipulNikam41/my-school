package com.myschool.manageops.domain.entities;

import com.myschool.commons.entities.BaseEntity;
import com.myschool.commons.entities.Contact;
import com.myschool.commons.entities.ProfilePicture;
import com.myschool.constants.Privilege;
import com.myschool.constants.StaffRole;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Staff extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @JoinColumn(name = "profile_picture_id")
    @OneToOne
    private ProfilePicture profilePicture;

    private UUID instituteId;

    private String name;

    @JoinColumn(name = "contact_id")
    @OneToOne(fetch = FetchType.LAZY)
    @ManyToMany
    private Contact contact;

    private String dateOfBirth;

    @Enumerated
    private List<Privilege> privileges;

    @Column(nullable = false, scale = 2)
    private BigDecimal salary;

    @Enumerated(EnumType.STRING)
    private StaffRole primaryGoal;
}
