package com.myschool.controller;

import com.myschool.domain.dto.InstituteResponse;
import com.myschool.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class StaffPage {
    private final StaffService staffService;

    @GetMapping("/{id}")
    public List<InstituteResponse> getInstitutesOwnedBy(@PathVariable UUID id) {
        return staffService.getInstitutesOwnedByUser(id);
    }
}
