package com.myschool.controller;

import com.myschool.commons.domain.dto.InstituteResponse;
import com.myschool.commons.domain.dto.LocationCords;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/landing")
public class UserLandingPage {
    @GetMapping("/getAllInstitutes")
    public List<InstituteResponse> getAllInstitute(@RequestBody LocationCords cords) {
        return new ArrayList<>();
    }

    @GetMapping("/getAllInstitutes/category/{categoryId}")
    public List<InstituteResponse> getInstituteByCategory(@RequestBody LocationCords cords, @PathVariable String categoryId) {
        return new ArrayList<>();
    }
}
