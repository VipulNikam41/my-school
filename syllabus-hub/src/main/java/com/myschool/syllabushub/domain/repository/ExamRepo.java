package com.myschool.syllabushub.domain.repository;

import com.myschool.syllabushub.domain.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExamRepo extends JpaRepository<Exam, UUID> {
}
