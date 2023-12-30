package com.myschool.manageops.repository;

import com.myschool.manageops.entities.Institute;
import com.myschool.manageops.entities.Staff;
import com.myschool.commons.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface InstituteRepo extends JpaRepository<Institute, UUID> {
    @Query("SELECT u FROM User u " +
            "JOIN BatchStudents bs ON u.id = bs.studentId " +
            "JOIN Batch b ON bs.batchId = b.id " +
            "WHERE b.instituteId = :instituteId")
    List<User> findStudentsByInstituteId(@Param("instituteId") UUID instituteId);

    @Query("SELECT u FROM User u " +
            "JOIN BatchStudents bs ON u.id = bs.studentId " +
            "JOIN BatchCourseInstructor bci ON bs.batchId = bci.batchId " +
            "WHERE bci.courseId = :courseId")
    List<User> findStudentsByCourseId(@Param("courseId") UUID courseId);

    @Query("SELECT s FROM Staff s " +
            "WHERE s.instituteId = :instituteId " +
            "AND s.primaryGoal = INSTRUCTOR")
    List<Staff> findInstructorsByInstituteId(@Param("instituteId") UUID instituteId);

    List<Institute> findAllByOwnerId(UUID ownerId);

    List<Institute> findAllByHomeBranchId(UUID homeBranch);

    @Query("SELECT i FROM Institute i " +
            "WHERE s.contact. = :instituteId " +
            "AND s.primaryGoal = INSTRUCTOR")
    List<Institute> findByLocation(String xMin, String xMax, String yMin, String yMax);
}
