package com.myschool.manageops.controller;

import com.myschool.commons.dto.CourseResponse;
import com.myschool.commons.dto.StaffResponse;
import com.myschool.manageops.service.InstituteService;
import com.myschool.manageops.service.StaffService;
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

    @GetMapping("/{instituteId}/courses")
    public List<CourseResponse> getAllInstituteCourses(@PathVariable UUID instituteId) {
        return service.getCoursesForInstitute(instituteId);
    }

    @GetMapping("/{instituteId}/instructors")
    public List<StaffResponse> getAllInstructors(@PathVariable UUID instituteId) {
        return service.getInstructorsForInstitute(instituteId);
    }

}
