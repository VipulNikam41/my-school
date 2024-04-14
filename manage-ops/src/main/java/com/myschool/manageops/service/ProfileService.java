package com.myschool.manageops.service;

import com.myschool.commons.dto.LoginRequest;
import com.myschool.commons.dto.UserRequest;
import com.myschool.commons.dto.UserResponse;
import com.myschool.commons.dto.console.AddStudent;
import com.myschool.commons.dto.support.ApiResponseStatus;
import com.myschool.constants.ResponseCode;
import com.myschool.constants.ResponseId;
import com.myschool.constants.UserRole;
import com.myschool.manageops.domain.entities.User;
import com.myschool.manageops.domain.entities.UserCredentials;
import com.myschool.manageops.domain.mapper.UserMapper;
import com.myschool.manageops.domain.repository.UserCredentialsRepo;
import com.myschool.manageops.domain.repository.UserRepo;
import com.myschool.manageops.utils.PasswordUtil;
import com.myschool.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileService {
    private final UserRepo userRepo;
    private final UserCredentialsRepo userCredentialsRepo;

    private final UserMapper userMapper;

    public UserResponse registerUser(UserRequest request) {
        List<User> users = userRepo.getUserByContact(request.getContact().getEmail(), request.getContact().getPhoneNumber());
        if (!CollectionUtils.isEmpty(users)) {
            boolean registeredUser = users.stream().anyMatch(
                    u -> u.getContact().isEmailVerified() ||
                            u.getContact().isPhoneNumberVerified()
            );
            if (registeredUser) {
                ApiResponseStatus apiResponseStatus = new ApiResponseStatus();
                apiResponseStatus.setId(ResponseId.FAILURE);
                apiResponseStatus.setCode(ResponseCode.REGISTRATION_201);
                UserResponse userResponse = new UserResponse();
                userResponse.setApiResponseStatus(apiResponseStatus);
                return userResponse;
            }
        }

        request.setName(Utils.beautify(request.getName()));
        if (request.getPrimaryGoal() == null) {
            request.setPrimaryGoal(UserRole.STUDENT);
        }

        User user = userMapper.dtoToEntity(request);
        userRepo.save(user);
        UserResponse userResponse = userMapper.entityToDto(user);
        ApiResponseStatus apiResponseStatus = new ApiResponseStatus();
        apiResponseStatus.setId(ResponseId.SUCCESS);
        apiResponseStatus.setCode(ResponseCode.REGISTRATION_100);
        userResponse.setApiResponseStatus(apiResponseStatus);
        return userResponse;
    }

    public UserResponse getUser(UUID userId) {
        log.info(" :: getUser :: requested for user {}", userId);
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
        if (email == null && phoneNumber == null) {
            return Collections.emptyList();
        }
        if (phoneNumber == null) {
            return userRepo.findByContactEmail(email);
        }
        return userRepo.findByContactPhoneNumber(phoneNumber);
    }

    public List<UserResponse> getStudentByIdIn(List<UUID> studentIds) {
        return null;
    }

    public Boolean validateAndUpdate(AddStudent request, UUID studentId) {
        return true;
    }

    public UUID getUser(LoginRequest loginRequest) {
        List<User> users = userRepo.getUserByContact(loginRequest.getEmailId(), null);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }

        User selectedUser = users.get(0);
        UserCredentials credentials = userCredentialsRepo.findById(selectedUser.getId()).orElse(null);
        if (credentials == null || !PasswordUtil.matchPassword(loginRequest.getPassword(), credentials.getPassword())) {
            return null;
        }
        return selectedUser.getId();
    }

    public List<User> getStudentByContactForInstitute(String email, String phoneNumber, UUID instituteId) {
        return userRepo.getStudentByContactForInstitute(email, phoneNumber, instituteId);
    }
}
