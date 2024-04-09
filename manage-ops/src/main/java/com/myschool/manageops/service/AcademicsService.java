package com.myschool.manageops.service;

import com.myschool.commons.dto.InstituteResponse;
import com.myschool.manageops.domain.mapper.UserMapper;
import com.myschool.manageops.domain.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AcademicsService {
    private final UserRepo userRepo;

    private final UserMapper userMapper;

    public List<InstituteResponse> getUserInstitutes(UUID userId) {
        return null;
    }
}
