package com.myschool.service;

import com.myschool.domain.dto.InstituteRequest;
import com.myschool.domain.dto.UserProfileResponse;
import com.myschool.domain.mapper.InstituteMapper;
import com.myschool.domain.repository.InstituteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InstituteService {
    private final InstituteRepo instituteRepo;
    private final InstituteMapper instituteMapper;

    public void validateAndAdd(InstituteRequest request) {
        instituteRepo.save(instituteMapper.dtoToEntity(request));
    }

    public List<UserProfileResponse> getStudentsForInstitute(UUID instituteId) {
        if(instituteId == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>();
    }
}
