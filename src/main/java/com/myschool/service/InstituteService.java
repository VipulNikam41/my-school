package com.myschool.service;

import com.myschool.domain.dto.InstituteDTO;
import com.myschool.domain.mapper.InstituteMapper;
import com.myschool.domain.repository.InstituteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituteService {
    @Autowired
    private InstituteRepo instituteRepo;
    @Autowired
    private InstituteMapper instituteMapper;

    public void validateAndAdd(InstituteDTO instituteDTO) {
        instituteRepo.save(instituteMapper.dtoToEntity(instituteDTO));
    }
}
