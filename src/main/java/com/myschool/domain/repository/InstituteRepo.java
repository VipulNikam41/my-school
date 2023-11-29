package com.myschool.domain.repository;

import com.myschool.domain.entities.Institute;
import com.myschool.domain.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface InstituteRepo extends JpaRepository<Institute, UUID> {
    @Query("SELECT u FROM UserProfile u " +
            "JOIN StudentCourses sc ON u.id = sc.studentId " +
            "JOIN Courses c ON sc.courseId = c.id " +
            "WHERE c.instituteId = :instituteId")
    List<UserProfile> findStudentsByInstituteId(@Param("instituteId") UUID instituteId);
}
