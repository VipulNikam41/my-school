package com.myschool.syllabushub.service;

import com.myschool.commons.dto.ExamResultRequest;
import com.myschool.commons.dto.ExamResultResponse;
import com.myschool.syllabushub.entities.ExamResults;
import com.myschool.syllabushub.mapper.ExamResultMapper;
import com.myschool.syllabushub.repository.ExamResultsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExamService {
    private final ExamResultsRepo examResultsRepo;
    private final ExamResultMapper examResultMapper;

    public ExamResultResponse getScoreForExam(UUID examId, ExamResultRequest request) {
        ExamResults examResults = examResultsRepo.getByLectureIdAndStudentId(examId, request.getStudentId());

        return examResultMapper.entityToDto(examResults);
    }
}
