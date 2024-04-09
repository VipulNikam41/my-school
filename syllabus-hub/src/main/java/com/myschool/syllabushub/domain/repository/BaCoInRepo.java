package com.myschool.syllabushub.domain.repository;

import com.myschool.syllabushub.domain.entities.BatchCourseInstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BaCoInRepo extends JpaRepository<BatchCourseInstructor, UUID> {
}
