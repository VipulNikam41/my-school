package com.myschool.commons.entities;

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

    @JoinColumn(name = "profile_picture_id")
    @OneToOne
    private ProfilePicture profilePicture;

    private String name;

    private String userName;

    private String motto;

    private String about;

    private Date establishedOn;

    private UUID ownerId;

    @JoinColumn(name = "contact_id")
    @OneToOne
    private Contact contact;

    private UUID homeBranchId;

    public boolean isSubBranch() {
        return homeBranchId != null;
    }

    public String getAbout() {
        return this.about;
    }
}
