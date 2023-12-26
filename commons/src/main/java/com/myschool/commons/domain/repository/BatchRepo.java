package com.myschool.commons.domain.repository;

import com.myschool.commons.domain.entities.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BatchRepo extends JpaRepository<Batch, UUID> {
    Batch findByIdAndInstituteId(UUID id, UUID instituteId);
}
