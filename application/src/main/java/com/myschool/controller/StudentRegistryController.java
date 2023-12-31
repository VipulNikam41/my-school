package com.myschool.controller;

import com.myschool.commons.dto.UserResponse;
import com.myschool.commons.dto.console.AddStudent;
import com.myschool.constants.ResponseCode;
import com.myschool.constants.endpoints.ConsoleApi;
import com.myschool.service.BatchService;
import com.myschool.service.InstituteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class StudentRegistryController {
    private final InstituteService instituteService;
    private final BatchService batchService;

    @PostMapping(ConsoleApi.ADD_STUDENT)
    public ResponseCode addStudent(@RequestBody AddStudent request, @PathVariable UUID instituteId) {
        return batchService.addStudent(request, instituteId);
    }

    @GetMapping(ConsoleApi.GET_STUDENT)
    public List<UserResponse> getStudents(@PathVariable UUID instituteId, @PathVariable UUID batchId, @RequestParam List<UUID> studentId) {
        return batchService.getStudents(instituteId, batchId, studentId);
    }

    @PostMapping(ConsoleApi.UPDATE_STUDENT)
    public Boolean updateStudent(@PathVariable AddStudent request, @PathVariable UUID instituteId, @PathVariable UUID batchId, @RequestParam UUID studentId) {
        return batchService.updateStudent(request, instituteId, batchId, studentId);
    }
}
