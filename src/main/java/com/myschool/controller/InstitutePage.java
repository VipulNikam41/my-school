package com.myschool.controller;

import com.myschool.domain.dto.*;
import com.myschool.service.InstituteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/institute")
@RequiredArgsConstructor
public class InstitutePage {
    private final InstituteService service;

    @PostMapping("/add")
    public boolean addInstitute(@RequestBody InstituteRequest request) {
        service.validateAndAdd(request);
        return true;
    }

    @PostMapping("{instituteId}/add")
    public boolean addSubInstitute(@RequestBody InstituteRequest request, @PathVariable UUID instituteId) {
        service.validateAndAdd(request, instituteId);
        return true;
    }

    @PostMapping("/{instituteId}/course/add")
    public boolean addCourse(@RequestBody CourseRequest request, @PathVariable UUID instituteId) {
        service.validateAndAdd(request, instituteId);
        return true;
    }

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
