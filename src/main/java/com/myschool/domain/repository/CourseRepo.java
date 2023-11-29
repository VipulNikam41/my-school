package com.myschool.domain.repository;

import com.myschool.domain.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CourseRepo extends JpaRepository<Courses, UUID> {
    List<Courses> findByInstituteId(UUID instituteId);
}
