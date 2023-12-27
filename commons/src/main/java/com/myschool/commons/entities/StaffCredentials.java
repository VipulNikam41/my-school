package com.myschool.commons.entities;

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
