package com.myschool.syllabushub.domain.repository;

import com.myschool.syllabushub.domain.entities.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface LectureRepo extends JpaRepository<Lecture, UUID> {
    @Query("SELECT l FROM Lecture l " +
            "WHERE l.baCoIn.id = :baCoInId " +
            "AND ((:startTime BETWEEN l.startTime AND l.endTime) " +
            "OR (:endTime BETWEEN l.startTime AND l.endTime) " +
            "OR (l.startTime BETWEEN :startTime AND :endTime) " +
            "OR (l.endTime BETWEEN :startTime AND :endTime))")
    List<Lecture> findOverlappingLectures(UUID baCoInId, Date startTime, Date endTime);

    @Query("SELECT l FROM Lecture l " +
            "WHERE l.baCoIn.id = :baCoInId ")
    Lecture findByBaCoInId(UUID baCoInId);
}
