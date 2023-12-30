package com.myschool.explorer.controller;

import com.myschool.commons.dto.InstituteResponse;
import com.myschool.commons.dto.LocationCords;
import com.myschool.constants.endpoints.ExplorerApi;
import com.myschool.explorer.service.ExplorerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserLandingPage {
    private final ExplorerService explorerService;

    @GetMapping(ExplorerApi.GET_ALL_INSTITUTES)
    public List<InstituteResponse> getAllInstitute(@RequestBody LocationCords cords) {
        return explorerService.getAllInstitute(cords);
    }

    @GetMapping(ExplorerApi.GET_INSTITUTES_BY_CATEGORY)
    public List<InstituteResponse> getInstituteByCategory(@RequestBody LocationCords cords, @PathVariable String categoryId) {
        return explorerService.getInstituteByCategory(cords, categoryId);
    }
}
