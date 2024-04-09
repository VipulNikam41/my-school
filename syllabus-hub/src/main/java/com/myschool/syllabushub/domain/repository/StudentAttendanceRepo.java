package com.myschool.syllabushub.domain.repository;

import com.myschool.syllabushub.domain.entities.Lecture;
import com.myschool.syllabushub.domain.entities.StudentAttendance;
import com.myschool.syllabushub.domain.entities.StudentLectureKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface StudentAttendanceRepo extends JpaRepository<StudentAttendance, StudentLectureKey> {
    @Query("SELECT l FROM Lecture l " +
            "INNER JOIN StudentAttendance sa ON l.id = sa.id.lectureId " +
            "WHERE sa.id.studentId = :studentId AND " +
            "l.startTime BETWEEN :from AND :till")
    List<Lecture> getByStudentWithinTimeFrom(UUID studentId, Date from, Date till);

    @Query("SELECT sa FROM StudentAttendance sa " +
            "WHERE sa.id.lectureId = :lectureId")
    List<StudentAttendance> getStudentsForLecture(UUID lectureId);
}
