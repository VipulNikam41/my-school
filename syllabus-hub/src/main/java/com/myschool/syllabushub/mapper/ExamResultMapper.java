package com.myschool.syllabushub.mapper;

import com.myschool.commons.dto.ExamResultRequest;
import com.myschool.commons.dto.ExamResultResponse;
import com.myschool.syllabushub.entities.ExamResults;
import org.mapstruct.Mapper;

@Mapper
public interface ExamResultMapper {
    ExamResults dtoToEntity(ExamResultRequest request);

    ExamResultResponse entityToDto(ExamResults results);
}
