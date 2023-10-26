package com.myscool.controller;

import com.myscool.domain.entities.UserProfile;
import com.myscool.domain.repository.UserProfileRepo;
import com.myscool.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class UserProfilePage {
    @Autowired
    InstituteService instituteService;
    @Autowired
    private UserProfileRepo userRepo;

    @GetMapping("/id/{id}")
    public UserProfile getStudentById(@PathVariable UUID id) {
        Optional<UserProfile> userProfile = userRepo.findById(id);
        if (userProfile.isEmpty()) {
            return null;
        }
        return userProfile.get();
    }

    @PostMapping("/add")
    public Boolean addStudent(@RequestBody UserProfile user) {
        try {
            userRepo.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
