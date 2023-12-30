package com.myschool.syllabushub.repository;

import com.myschool.syllabushub.entities.ExamResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExamResultsRepo extends JpaRepository<ExamResults, UUID> {
    ExamResults getByLectureIdAndStudentId(UUID lectureId, UUID studentId);
}
