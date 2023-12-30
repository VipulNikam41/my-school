package com.myschool.scheduler.controller;

import com.myschool.scheduler.service.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trigger")
@RequiredArgsConstructor
public class SchedulerController {
    private final Schedule studentMerge;

    @GetMapping("/mergeStudent")
    public Boolean mergeStudents() {
        studentMerge.trigger();
        return true;
    }
}
