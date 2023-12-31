package com.myschool.syllabushub.controller;

import com.myschool.commons.dto.LectureResponse;
import com.myschool.constants.endpoints.SyllabusHubApi;
import com.myschool.syllabushub.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;

    @GetMapping(SyllabusHubApi.GET_LECTURE_DETAILS)
    public LectureResponse getLectureDetails(@PathVariable UUID lectureId) {
        return lectureService.getLectureDetails(lectureId);
    }

}
