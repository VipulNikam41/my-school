package com.myschool.manageops.domain.entities;

import com.myschool.commons.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class UserCredentials extends BaseEntity {
    @Id
    private UUID userId;
    private String password;
}
