package com.myschool.service;

import com.myschool.domain.dto.InstituteResponse;
import com.myschool.domain.entities.Institute;
import com.myschool.domain.mapper.InstituteMapper;
import com.myschool.domain.repository.InstituteRepo;
import com.myschool.domain.repository.StaffRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StaffService {
    private final StaffRepo staffRepo;
    private final InstituteRepo instituteRepo;

    private final InstituteMapper instituteMapper;

    public List<InstituteResponse> getInstitutesOwnedByUser(UUID id) {
        List<Institute> institutes = instituteRepo.findAllByOwnerId(id);

        if (CollectionUtils.isEmpty(institutes)) {
            return Collections.emptyList();
        }

        return institutes.stream()
                .map(instituteMapper::entityToDto)
                .toList();
    }

}
