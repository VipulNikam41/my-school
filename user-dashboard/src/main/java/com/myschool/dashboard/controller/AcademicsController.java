package com.myschool.dashboard.controller;

import com.myschool.commons.dto.InstituteResponse;
import com.myschool.constants.endpoints.DashboardApi;
import com.myschool.dashboard.service.AcademicsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AcademicsController {
    private final AcademicsService academicsService;

    @GetMapping(DashboardApi.GET_INSTITUTES)
    public List<InstituteResponse> getUserInstitutes(UUID userId) {
        return academicsService.getUserInstitutes(userId);
    }
}
