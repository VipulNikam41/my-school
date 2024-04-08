package com.myschool.syllabushub.domain.mapper;

import com.myschool.commons.dto.ExamResultRequest;
import com.myschool.commons.dto.ExamResultResponse;
import com.myschool.commons.dto.syllabushub.ExamRequest;
import com.myschool.syllabushub.domain.entities.Exam;
import com.myschool.syllabushub.domain.entities.ExamResults;
import org.mapstruct.Mapper;

@Mapper
public interface ExamMapper {
    Exam requestToEntity(ExamRequest request);

    ExamResults dtoToEntity(ExamResultRequest request);

    ExamResultResponse entityToDto(ExamResults results);
}
