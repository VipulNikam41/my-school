package com.myschool.controller;

import com.myschool.domain.dto.UserProfileRequest;
import com.myschool.domain.dto.UserProfileResponse;
import com.myschool.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserProfilePage {
    private final UserProfileService userProfileService;

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileResponse> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(userProfileService.getUserById(id));
    }

    @PostMapping("/add")
    public Boolean addUser(@RequestBody UserProfileRequest user) {
        return userProfileService.validateAndAdd(user);
    }

    @PostMapping("/update/{id}")
    public Boolean updateUser(@RequestBody UserProfileRequest user, @PathVariable UUID id) {
        return userProfileService.validateAndUpdate(user, id);
    }
}
