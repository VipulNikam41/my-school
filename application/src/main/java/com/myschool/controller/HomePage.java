package com.myschool.controller;

import com.myschool.commons.dto.UserResponse;
import com.myschool.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class HomePage {
    private final UserService userService;

    @GetMapping("/home")
    public String home() {
        return "Home Page";
    }

    @GetMapping("/profile/{userId}/get")
    public UserResponse getUser(@PathVariable UUID userId) {
        return userService.getUserById(userId);
    }
}
