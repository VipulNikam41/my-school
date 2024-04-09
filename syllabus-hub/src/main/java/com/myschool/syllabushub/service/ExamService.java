package com.myschool.syllabushub.service;

import com.myschool.commons.dto.ExamResultRequest;
import com.myschool.commons.dto.ExamResultResponse;
import com.myschool.commons.dto.syllabushub.ExamRequest;
import com.myschool.syllabushub.domain.entities.Exam;
import com.myschool.syllabushub.domain.entities.ExamResults;
import com.myschool.syllabushub.domain.entities.StudentLectureKey;
import com.myschool.syllabushub.domain.mapper.ExamMapper;
import com.myschool.syllabushub.domain.mapper.LectureMapper;
import com.myschool.syllabushub.domain.repository.ExamRepo;
import com.myschool.syllabushub.domain.repository.ExamResultsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExamService {
    private final ExamResultsRepo examResultsRepo;
    private final ExamRepo examRepo;
    private final ExamMapper examMapper;
    private final LectureMapper lectureMapper;

    public ExamResultResponse getScoreForExam(ExamResultRequest request) {
        ExamResults examResults = examResultsRepo.findById(
                new StudentLectureKey(request.getExamId(), request.getStudentId())
        ).orElse(null);

        return examMapper.entityToDto(examResults);
    }

    public Boolean addExam(ExamRequest examRequest) {
        Exam exam = examMapper.requestToEntity(examRequest);
        examRepo.save(exam);
        return true;
    }
}
