package com.myschool.manageops.domain.repository;

import com.myschool.manageops.domain.entities.BatchStudents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BatchStudentsRepo extends JpaRepository<BatchStudents, UUID> {
}
