package com.myschool.manageops.entities;

import com.myschool.commons.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;


@Entity
@Data
public class StaffCredentials extends BaseEntity {
    @Id
    private UUID staffId;
    private String password;
}
