package com.myschool.service;

import com.myschool.domain.dto.InstituteDTO;
import com.myschool.domain.mapper.InstituteMapper;
import com.myschool.domain.repository.InstituteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstituteService {
    private final InstituteRepo instituteRepo;
    private final InstituteMapper instituteMapper;

    public void validateAndAdd(InstituteDTO instituteDTO) {
        instituteRepo.save(instituteMapper.dtoToEntity(instituteDTO));
    }
}
