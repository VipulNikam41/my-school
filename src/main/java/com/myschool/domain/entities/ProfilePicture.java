package com.myschool.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class ProfilePicture extends BaseEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String color;

    private String imageLink;
}
