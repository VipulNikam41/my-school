package com.myschool.syllabushub.service;

import com.myschool.commons.dto.LectureResponse;
import com.myschool.syllabushub.entities.Lecture;
import com.myschool.syllabushub.mapper.LectureMapper;
import com.myschool.syllabushub.repository.LectureRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class LectureService {
    private final LectureRepo lectureRepo;

    private final LectureMapper lectureMapper;

    public LectureResponse getLectureDetails(UUID lectureId) {
        Lecture lecture = lectureRepo.findById(lectureId).orElse(null);
        return lectureMapper.entityToDto(lecture);
    }
}
