package com.myschool.manageops.domain.repository;

import com.myschool.manageops.domain.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CourseRepo extends JpaRepository<Course, UUID> {
    List<Course> findByInstituteId(UUID instituteId);
}
