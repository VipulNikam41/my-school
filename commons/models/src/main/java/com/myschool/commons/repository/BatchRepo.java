package com.myschool.commons.repository;

import com.myschool.commons.entities.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BatchRepo extends JpaRepository<Batch, UUID> {
    Batch findByIdAndInstituteId(UUID id, UUID instituteId);
}
