package com.myschool.dashboard.controller;

import com.myschool.commons.dto.UserRequest;
import com.myschool.commons.dto.UserResponse;
import com.myschool.constants.endpoints.DashboardApi;
import com.myschool.constants.ResponseCode;
import com.myschool.dashboard.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping(DashboardApi.REGISTER_PROFILE)
    public ResponseCode registerUser(@RequestBody UserRequest request) {
        return profileService.registerUser(request);
    }

    @GetMapping(DashboardApi.GET_PROFILE)
    public UserResponse getUser(@PathVariable UUID userId) {
        return profileService.getUser(userId);
    }

    @PostMapping(DashboardApi.UPDATE_PROFILE)
    public ResponseCode updateUserInfo(@RequestBody UserRequest request, @PathVariable UUID userId) {
        return profileService.updateUser(request, userId);
    }
}
