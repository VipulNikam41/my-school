package com.myschool.controller;

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

    @GetMapping("/get/students")
    public List<UserProfileResponse> getAllInstituteStudent(UUID instituteId) {
        return service.getStudentsForInstitute(instituteId);
    }
}
