package com.myschool.syllabushub.mapper;

import com.myschool.commons.dto.ExamResultRequest;
import com.myschool.commons.dto.ExamResultResponse;
import com.myschool.commons.dto.LectureResponse;
import com.myschool.syllabushub.entities.ExamResults;
import com.myschool.syllabushub.entities.Lecture;
import org.mapstruct.Mapper;

@Mapper
public interface LectureMapper {
    LectureResponse entityToDto(Lecture lecture);
}
