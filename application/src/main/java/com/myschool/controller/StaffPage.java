package com.myschool.controller;

import com.myschool.commons.constants.ResponseCode;
import com.myschool.commons.dto.CourseRequest;
import com.myschool.commons.dto.InstituteRequest;
import com.myschool.commons.dto.InstituteResponse;
import com.myschool.commons.dto.StaffRequest;
import com.myschool.commons.dto.console.AddBatch;
import com.myschool.commons.dto.console.AddStudent;
import com.myschool.commons.dto.console.OwnerRegistrationRequest;
import com.myschool.service.BatchService;
import com.myschool.service.InstituteService;
import com.myschool.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/console")
public class StaffPage {
    private final StaffService staffService;
    private final InstituteService instituteService;
    private final BatchService batchService;

    @GetMapping("/register")
    public Boolean addOwner(@PathVariable OwnerRegistrationRequest request) {
        return staffService.addOwner(request);
    }

    @PostMapping("/add")
    public boolean addInstitute(@RequestBody InstituteRequest request) {
        instituteService.validateAndAdd(request);
        return true;
    }

    @PostMapping("{instituteId}/add")
    public boolean addSubInstitute(@RequestBody InstituteRequest request, @PathVariable UUID instituteId) {
        instituteService.validateAndAdd(request, instituteId);
        return true;
    }

    @GetMapping("/{id}")
    public List<InstituteResponse> getInstitutesOwnedBy(@PathVariable UUID id) {
        return staffService.getInstitutesOwnedByUser(id);
    }

    @PostMapping("{instituteId}/batch/add")
    public UUID addBatch(@RequestBody AddBatch request, @PathVariable UUID instituteId) {
        return batchService.validateAndAdd(request, instituteId);
    }

    @PostMapping("{instituteId}/batch/student/add")
    public ResponseCode addStudent(@RequestBody AddStudent request, @PathVariable UUID instituteId) {
        return batchService.addStudent(request, instituteId);
    }

    @GetMapping("/{instituteId}/staff/add")
    public Boolean addStaff(@PathVariable StaffRequest request, @PathVariable UUID instituteId) {
        return staffService.onboardStaff(request);
    }

    @PostMapping("/{instituteId}/course/add")
    public boolean addCourse(@RequestBody CourseRequest request, @PathVariable UUID instituteId) {
        instituteService.validateAndAdd(request, instituteId);
        return true;
    }
}
