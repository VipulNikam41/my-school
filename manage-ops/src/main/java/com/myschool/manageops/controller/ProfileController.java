package com.myschool.manageops.controller;

import com.myschool.commons.dto.UserRequest;
import com.myschool.commons.dto.UserResponse;
import com.myschool.constants.ResponseCode;
import com.myschool.constants.endpoints.DashboardApi;
import com.myschool.manageops.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping(DashboardApi.REGISTER_PROFILE)
    public UserResponse registerUser(ServerHttpRequest request, @RequestBody UserRequest userRequest) {
        return profileService.registerUser(userRequest);
    }

    @GetMapping(DashboardApi.GET_PROFILE)
    public UserResponse getUser(@PathVariable UUID userId) {
        return profileService.getUser(userId);
    }

    @PostMapping(DashboardApi.UPDATE_PROFILE)
    public ResponseCode updateUserInfo(ServerHttpRequest request, @RequestBody UserRequest userRequest, @PathVariable UUID userId) {
        return profileService.updateUser(userRequest, userId);
    }
}
