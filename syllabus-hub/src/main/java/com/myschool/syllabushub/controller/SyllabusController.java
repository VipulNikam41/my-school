package com.myschool.syllabushub.controller;

import com.myschool.commons.dto.syllabushub.AddBaCoIn;
import com.myschool.commons.dto.syllabushub.LectureRequest;
import com.myschool.commons.dto.syllabushub.LectureResponse;
import com.myschool.constants.endpoints.SyllabusHubApi;
import com.myschool.syllabushub.service.BaCoInService;
import com.myschool.syllabushub.service.SyllabusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SyllabusController {
    private final SyllabusService syllabusService;
    private final BaCoInService baCoInService;

    @PostMapping(SyllabusHubApi.ADD_BACOIN)
    public UUID addBaCoIn(@RequestBody AddBaCoIn addBaCoIn) {
        return baCoInService.addBaCoIn(addBaCoIn);
    }

    @GetMapping(SyllabusHubApi.GET_LECTURE_DETAILS)
    public LectureResponse getLectureDetails(@RequestParam(required = false) UUID lectureId, @RequestParam(required = false) UUID baCoInId) {
        return syllabusService.getLectureDetails(lectureId, baCoInId);
    }

    @PostMapping(SyllabusHubApi.ADD_LECTURE)
    public LectureResponse addLecture(@RequestBody LectureRequest lectureRequest) {
        return syllabusService.addLecture(lectureRequest);
    }

}
