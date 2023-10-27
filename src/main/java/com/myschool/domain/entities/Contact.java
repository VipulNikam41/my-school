package com.myscool.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Contact extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String email;

    private String phoneNumber;

    private String address;

    private String addressPin;
}
