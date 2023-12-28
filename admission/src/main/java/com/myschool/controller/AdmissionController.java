package com.myschool.controller;

import com.myschool.commons.dto.console.AddStudent;
import com.myschool.constants.ResponseCode;
import com.myschool.service.AdmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AdmissionController {
    private final AdmissionService admissionService;

    @PostMapping("{instituteId}/batch/student/add")
    public ResponseCode addStudent(@RequestBody AddStudent request, @PathVariable UUID instituteId) {
        return admissionService.addStudent(request, instituteId);
    }

    @PostMapping("{instituteId}/batch/student/existing/add")
    public ResponseCode addExistingStudent(@RequestBody AddStudent request, @PathVariable UUID instituteId) {
        return admissionService.addExistingStudent(request, instituteId);
    }

    @GetMapping("admission/home")
    public String admissionHome() {
        return "Admission server up";
    }

}
