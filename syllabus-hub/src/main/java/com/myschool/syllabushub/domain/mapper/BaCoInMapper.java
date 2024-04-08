package com.myschool.syllabushub.domain.mapper;

import com.myschool.commons.dto.syllabushub.AddBaCoIn;
import com.myschool.syllabushub.domain.entities.BatchCourseInstructor;
import org.mapstruct.Mapper;

@Mapper
public interface BaCoInMapper {
    BatchCourseInstructor dtoToEntity(AddBaCoIn addBaCoIn);
}
