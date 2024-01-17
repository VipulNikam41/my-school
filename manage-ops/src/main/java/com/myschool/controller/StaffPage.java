package com.myschool.controller;

import com.myschool.commons.dto.BatchResponse;
import com.myschool.commons.dto.CourseRequest;
import com.myschool.commons.dto.console.BatchRequest;
import com.myschool.constants.endpoints.ConsoleApi;
import com.myschool.service.BatchService;
import com.myschool.service.InstituteService;
import com.myschool.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class StaffPage {
    private final StaffService staffService;
    private final InstituteService instituteService;
    private final BatchService batchService;

    @PostMapping(ConsoleApi.ADD_BATCH)
    public UUID addBatch(@RequestBody BatchRequest request, @PathVariable UUID instituteId) {
        return batchService.validateAndAdd(request, instituteId);
    }

    @GetMapping(ConsoleApi.GET_BATCHES)
    public List<BatchResponse> getBatches(@PathVariable UUID instituteId, @RequestParam List<UUID> batchId) {
        return batchService.getBatches(instituteId, batchId);
    }

    @PostMapping(ConsoleApi.UPDATE_BATCH)
    public Boolean updateBatch(@PathVariable BatchRequest request, @PathVariable UUID instituteId, @RequestParam UUID batchId) {
        return batchService.updateBatch(request, instituteId, batchId);
    }

    @PostMapping(ConsoleApi.ADD_COURSE)
    public boolean addCourse(@RequestBody CourseRequest request, @PathVariable UUID instituteId) {
        instituteService.validateAndAdd(request, instituteId);
        return true;
    }
}
