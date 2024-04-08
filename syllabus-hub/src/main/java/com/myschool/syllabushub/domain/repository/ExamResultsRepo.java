package com.myschool.syllabushub.domain.repository;

import com.myschool.syllabushub.domain.entities.ExamResults;
import com.myschool.syllabushub.domain.entities.StudentLectureKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamResultsRepo extends JpaRepository<ExamResults, StudentLectureKey> {
}
