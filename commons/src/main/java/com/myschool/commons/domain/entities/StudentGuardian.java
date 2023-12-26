package com.myschool.commons.domain.entities;

import com.myschool.commons.constants.GuardianPrivilege;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class StudentGuardian extends BaseEntity {
    @Id
    private UUID studentId;

    @Id
    private UUID guardianId;

    private List<GuardianPrivilege> guardianPrivileges;

    private boolean isPrimary;
}
