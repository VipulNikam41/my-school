package com.myschool.controller;

import com.myschool.domain.dto.CourseRequest;
import com.myschool.domain.dto.CourseResponse;
import com.myschool.domain.dto.InstituteRequest;
import com.myschool.domain.dto.UserProfileResponse;
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

    @PostMapping("/{instituteId}/course/add")
    public boolean addCourse(@RequestBody CourseRequest request, @PathVariable UUID instituteId) {
        service.validateAndAdd(request, instituteId);
        return true;
    }

    @GetMapping("/{instituteId}/students")
    public List<UserProfileResponse> getAllInstituteStudent(@PathVariable UUID instituteId) {
        return service.getStudentsForInstitute(instituteId);
    }

    @GetMapping("/{instituteId}/courses")
    public List<CourseResponse> getAllInstituteCourses(@PathVariable UUID instituteId) {
        return service.getCoursesForInstitute(instituteId);
    }
}
