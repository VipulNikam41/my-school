package com.myschool.manageops.controller;

import com.myschool.commons.dto.StatefulRequest;
import com.myschool.commons.dto.UserResponse;
import com.myschool.commons.dto.console.AddStudent;
import com.myschool.constants.ResponseCode;
import com.myschool.constants.endpoints.ConsoleApi;
import com.myschool.manageops.service.BatchService;
import com.myschool.manageops.service.InstituteService;
import com.myschool.manageops.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class StudentRegistryController {
    private final InstituteService instituteService;
    private final BatchService batchService;
    private final ProfileService profileService;

    @PostMapping(ConsoleApi.ADD_STUDENT)
    public ResponseCode addStudent(@RequestBody AddStudent request, @PathVariable UUID instituteId) {
        return batchService.addStudent(request, instituteId);
    }

    @GetMapping(ConsoleApi.GET_STUDENT)
    public List<UserResponse> getStudents(@PathVariable UUID instituteId, @RequestParam UUID batchId, @RequestParam List<UUID> studentId, @RequestParam UUID courseId) {
        return batchService.getStudents(instituteId, batchId, studentId);
    }

    @PostMapping(ConsoleApi.UPDATE_STUDENT)
    public Boolean updateStudent(@RequestBody AddStudent request, @PathVariable UUID instituteId, @RequestParam UUID batchId, @RequestParam UUID studentId) {
        return batchService.updateStudent(request, instituteId, batchId, studentId);
    }

    @GetMapping("/console/staff/batch/student/get")
    public UserResponse getStudents(@RequestParam UUID studentId, @RequestBody StatefulRequest statefulRequest) {
        return profileService.getUser(studentId);
    }
}
