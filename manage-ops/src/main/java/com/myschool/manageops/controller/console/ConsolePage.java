package com.myschool.manageops.controller.console;

import com.myschool.commons.dto.InstituteRequest;
import com.myschool.commons.dto.InstituteResponse;
import com.myschool.commons.dto.StaffRequest;
import com.myschool.commons.dto.console.OwnerRegistrationRequest;
import com.myschool.constants.endpoints.ConsoleApi;
import com.myschool.manageops.service.InstituteService;
import com.myschool.manageops.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ConsolePage {
    private final InstituteService instituteService;
    private final StaffService staffService;

    @PostMapping(ConsoleApi.REGISTER_OWNER)
    public Boolean addOwner(@PathVariable OwnerRegistrationRequest request) {
        return staffService.addOwner(request);
    }

    @PostMapping(ConsoleApi.ADD_INSTITUTE)
    public boolean addInstitute(@RequestBody InstituteRequest request) {
        instituteService.validateAndAdd(request);
        return true;
    }

    @PostMapping(ConsoleApi.ADD_SUB_INSTITUTE)
    public boolean addSubInstitute(@RequestBody InstituteRequest request, @PathVariable UUID instituteId) {
        instituteService.validateAndAdd(request, instituteId);
        return true;
    }

    @GetMapping(ConsoleApi.GET_INSTITUTES_BY_OWNER)
    public List<InstituteResponse> getInstitutesOwnedBy(@PathVariable UUID ownerId) {
        return staffService.getInstitutesOwnedByUser(ownerId);
    }

    @GetMapping(ConsoleApi.ADD_STAFF)
    public Boolean addStaff(@PathVariable StaffRequest request, @PathVariable UUID instituteId) {
        return staffService.onboardStaff(request, instituteId);
    }

    @PostMapping(ConsoleApi.UPDATE_STAFF)
    public Boolean updateStaff(@PathVariable StaffRequest request, @PathVariable UUID instituteId, @RequestParam UUID staffId) {
        return staffService.updateStaff(request, instituteId, staffId);
    }
}
