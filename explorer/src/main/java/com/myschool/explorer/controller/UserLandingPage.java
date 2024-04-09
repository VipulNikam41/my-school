package com.myschool.explorer.controller;

import com.myschool.commons.dto.InstituteResponse;
import com.myschool.commons.dto.LocationCords;
import com.myschool.constants.endpoints.ExplorerApi;
import com.myschool.explorer.service.ExplorerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
