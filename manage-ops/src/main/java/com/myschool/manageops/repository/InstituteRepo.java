package com.myschool.manageops.repository;

import com.myschool.manageops.entities.Institute;
import com.myschool.manageops.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface InstituteRepo extends JpaRepository<Institute, UUID> {
    @Query("SELECT bs.studentId FROM BatchStudents bs " +
            "JOIN Batch b ON bs.batchId = b.id " +
            "WHERE b.instituteId = :instituteId")
    List<UUID> findStudentsIdsByInstituteId(@Param("instituteId") UUID instituteId);

    @Query("SELECT s FROM Staff s " +
            "WHERE s.instituteId = :instituteId " +
            "AND s.primaryGoal = INSTRUCTOR")
    List<Staff> findInstructorsByInstituteId(@Param("instituteId") UUID instituteId);

    List<Institute> findAllByOwnerId(UUID ownerId);

    List<Institute> findAllByHomeBranchId(UUID homeBranch);

    @Query("SELECT i FROM Institute i " +
            "WHERE i.id = :instituteId " +
            "AND (i.contact.address = :xMin " +
            "OR i.contact.address = :xMax " +
            "OR i.contact.address = :yMin " +
            "OR i.contact.address = :yMax) ")
    List<Institute> findByLocation(String xMin, String xMax, String yMin, String yMax);
}
