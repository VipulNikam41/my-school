package com.myschool.controller;

import com.myschool.commons.domain.dto.UserRequest;
import com.myschool.commons.domain.dto.UserResponse;
import com.myschool.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsersPage {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/add")
    public Boolean addUser(@RequestBody UserRequest user) {
        return userService.validateAndAdd(user);
    }

    @PostMapping("/{id}/update")
    public Boolean updateUser(@RequestBody UserRequest user, @PathVariable UUID id) {
        return userService.validateAndUpdate(user, id);
    }
}
