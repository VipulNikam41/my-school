package com.myscool.service;

import com.myscool.domain.dto.InstituteDTO;
import com.myscool.domain.mapper.InstituteMapper;
import com.myscool.domain.repository.InstituteRepo;
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
