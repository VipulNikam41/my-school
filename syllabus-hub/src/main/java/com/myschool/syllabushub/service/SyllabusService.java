package com.myschool.syllabushub.service;

import com.myschool.commons.dto.syllabushub.LectureRequest;
import com.myschool.commons.dto.syllabushub.LectureResponse;
import com.myschool.syllabushub.domain.entities.Lecture;
import com.myschool.syllabushub.domain.mapper.LectureMapper;
import com.myschool.syllabushub.domain.repository.LectureRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class SyllabusService {
    private final LectureRepo lectureRepo;

    private final LectureMapper lectureMapper;

    public LectureResponse getLectureDetails(UUID lectureId, UUID baCoInId) {
        Lecture lecture;
        if (lectureId == null) {
            lecture = lectureRepo.findByBaCoInId(baCoInId);
        } else {
            lecture = lectureRepo.findById(lectureId).orElse(null);
        }
        return lectureMapper.entityToDto(lecture);
    }

    public LectureResponse addLecture(LectureRequest lectureRequest) {
        LectureResponse lectureResponse;
        if (!lectureRequest.getStartTime().before(lectureRequest.getEndTime())) {
            lectureResponse = new LectureResponse();
            ResponseConstructor.setFaultyLectureError(lectureResponse);
            return lectureResponse;
        }
        List<Lecture> lectures = lectureRepo.findOverlappingLectures(lectureRequest.getBaCoInId(), lectureRequest.getStartTime(), lectureRequest.getEndTime());
        if (!CollectionUtils.isEmpty(lectures)) {
            log.error(this.getClass().getName(), " :: addLecture :: Overlapping Lectures found! ");
            lectureResponse = lectureMapper.entityToDto(lectures.get(0));
            ResponseConstructor.setOverlappingLectureError(lectureResponse);
            return lectureResponse;
        }
        Lecture lecture = lectureMapper.dtoToEntity(lectureRequest);
        lectureRepo.save(lecture);
        lectureResponse = lectureMapper.entityToDto(lecture);
        ResponseConstructor.setSuccess(lectureResponse);
        return lectureResponse;
    }
}
