package com.myschool.dashboard.service;

import com.myschool.commons.dto.UserRequest;
import com.myschool.commons.dto.UserResponse;
import com.myschool.commons.entities.User;
import com.myschool.commons.mapper.UserMapper;
import com.myschool.commons.repository.UserRepo;
import com.myschool.constants.ResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileService {
    private final UserRepo userRepo;

    private final UserMapper userMapper;

    public ResponseCode registerUser(UserRequest request) {
        List<User> users = userRepo.getUserByContact(request.getContact().getEmail(), request.getContact().getPhoneNumber());
        if (!CollectionUtils.isEmpty(users)) {
            return ResponseCode.REGISTRATION_201;
        }

        User user = userMapper.dtoToEntity(request);
        userRepo.save(user);
        return ResponseCode.REGISTRATION_100;
    }

    public UserResponse getUser(UUID userId) {
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }

        return userMapper.entityToDto(user);
    }

    public ResponseCode updateUser(UserRequest request, UUID userId) {
        User user = userRepo.findById(userId).orElse(null);

        if (user == null) {
            return ResponseCode.FAILURE_200;
        }

        user = userMapper.dtoToEntity(request);
        user.setId(userId);

        userRepo.save(user);
        return ResponseCode.REGISTRATION_100;
    }
}
