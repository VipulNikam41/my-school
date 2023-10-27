package com.myschool.controller;

import com.myschool.domain.dto.InstituteDTO;
import com.myschool.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/institute")
public class InstitutePage {
    @Autowired
    private InstituteService service;

    @PostMapping("/add")
    public boolean addInstitute(@RequestBody InstituteDTO instituteDTO) {
        service.validateAndAdd(instituteDTO);
        return true;
    }
}
