package com.myschool.controller;

import com.myschool.commons.domain.dto.CourseResponse;
import com.myschool.commons.domain.dto.StaffResponse;
import com.myschool.commons.domain.dto.UserResponse;
import com.myschool.service.InstituteService;
import com.myschool.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/institute")
@RequiredArgsConstructor
public class InstitutePage {
    private final InstituteService service;
    private final StaffService staffService;

    @GetMapping("/{instituteId}/students")
    public List<UserResponse> getAllInstituteStudent(@PathVariable UUID instituteId) {
        return service.getStudentsForInstitute(instituteId);
    }

    @GetMapping("/{instituteId}/{courseId}/students")
    public List<UserResponse> getCourseStudents(@PathVariable UUID instituteId, @PathVariable UUID courseId) {
        return service.getStudentsForCourse(instituteId, courseId);
    }

    @GetMapping("/{instituteId}/courses")
    public List<CourseResponse> getAllInstituteCourses(@PathVariable UUID instituteId) {
        return service.getCoursesForInstitute(instituteId);
    }

    @GetMapping("/{instituteId}/instructors")
    public List<StaffResponse> getAllInstructors(@PathVariable UUID instituteId) {
        return service.getInstructorsForInstitute(instituteId);
    }

}
