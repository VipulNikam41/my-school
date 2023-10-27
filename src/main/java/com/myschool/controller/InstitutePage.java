package com.myscool.controller;

import com.myscool.domain.dto.InstituteDTO;
import com.myscool.service.InstituteService;
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
