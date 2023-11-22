package com.myschool.domain.repository;

import com.myschool.domain.entities.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentCoursesRepo extends JpaRepository<StudentCourses, UUID> {
    List<StudentCourses> findByCourseIdIn(List<UUID> courseId);
}
