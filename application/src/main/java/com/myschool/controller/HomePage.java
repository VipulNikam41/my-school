package com.myschool.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomePage {
    @GetMapping("/home")
    public String home() {
        return "Home Page";
    }
}
