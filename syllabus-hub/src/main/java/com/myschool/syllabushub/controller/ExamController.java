package com.myschool.syllabushub.controller;

import com.myschool.commons.dto.ExamResultRequest;
import com.myschool.commons.dto.ExamResultResponse;
import com.myschool.commons.dto.syllabushub.ExamRequest;
import com.myschool.constants.endpoints.SyllabusHubApi;
import com.myschool.syllabushub.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ExamController {
    private ExamService examService;

    @GetMapping(SyllabusHubApi.ADD_EXAM)
    public Boolean addExam(@RequestBody ExamRequest examRequest) {
        return examService.addExam(examRequest);
    }

    @GetMapping(SyllabusHubApi.GET_EXAM_RESULT)
    public ExamResultResponse getScore(@RequestBody ExamResultRequest request) {
        return examService.getScoreForExam(request);
    }

}
