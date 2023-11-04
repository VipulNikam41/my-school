package com.myscool.controller;

import com.myscool.domain.dto.UserProfileDTO;
import com.myscool.response.GetUserResponse;
import com.myscool.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserProfilePage {
    @Autowired
    UserProfileService userProfileService;

    @GetMapping("/id/{id}")
    public ResponseEntity<GetUserResponse> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(userProfileService.getUserById(id));
    }

    @PostMapping("/add")
    public Boolean addUser(@RequestBody UserProfileDTO user) {
        return userProfileService.validateAndAdd(user);
    }

    @PostMapping("/update")
    public Boolean updateUser(@RequestBody UserProfileDTO user) {
        return userProfileService.validateAndUpdate(user);
    }
}
