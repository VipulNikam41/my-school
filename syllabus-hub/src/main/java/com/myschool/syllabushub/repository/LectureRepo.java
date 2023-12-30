package com.myschool.syllabushub.repository;

import com.myschool.syllabushub.entities.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LectureRepo extends JpaRepository<Lecture, UUID> {
}
