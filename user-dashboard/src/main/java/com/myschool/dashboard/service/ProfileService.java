package com.myschool.dashboard.service;

import com.myschool.commons.dto.UserRequest;
import com.myschool.commons.dto.UserResponse;
import com.myschool.constants.ResponseCode;
import com.myschool.constants.UserRole;
import com.myschool.dashboard.entities.User;
import com.myschool.dashboard.mapper.UserMapper;
import com.myschool.dashboard.repository.UserRepo;
import com.myschool.utils.CollectionTool;
import com.myschool.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
        if (!CollectionTool.isEmpty(users)) {
            boolean registeredUser = users.stream().anyMatch(
                            u -> u.getContact().isEmailVerified() ||
                            u.getContact().isPhoneNumberVerified()
                    );
            if (registeredUser) {
                return ResponseCode.REGISTRATION_201;
            }
        }

        request.setName(Utils.beautify(request.getName()));
        if (request.getPrimaryGoal() == null) {
            request.setPrimaryGoal(UserRole.STUDENT);
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

    public List<User> getStudentByContact(String email, String phoneNumber) {
        if (email != null && phoneNumber != null) {
            return userRepo.getStudentByContact(email, phoneNumber);
        }

        if (email != null) {
            return Collections.singletonList(userRepo.getStudentByEmail(email));
        } else if (phoneNumber != null) {
            return Collections.singletonList(userRepo.getStudentByPhoneNumber(phoneNumber));
        }

        return Collections.emptyList();
    }
}
