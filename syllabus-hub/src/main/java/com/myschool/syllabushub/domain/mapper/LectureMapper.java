package com.myschool.syllabushub.domain.mapper;

import com.myschool.commons.dto.syllabushub.LectureRequest;
import com.myschool.commons.dto.syllabushub.LectureResponse;
import com.myschool.syllabushub.domain.entities.Lecture;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface LectureMapper {
    LectureResponse entityToDto(Lecture lecture);

    @Mapping(source = "baCoInId", target = "baCoIn.id")
    Lecture dtoToEntity(LectureRequest request);
}
