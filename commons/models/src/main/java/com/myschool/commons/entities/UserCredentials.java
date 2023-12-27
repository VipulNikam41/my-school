package com.myschool.commons.entities;

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
    private UUID password;
}
