package com.myscool.domain.repository;

import com.myscool.domain.entities.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface InstituteRepo extends JpaRepository<Institute, UUID> {
}
