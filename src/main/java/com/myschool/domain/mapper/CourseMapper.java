package com.myschool.domain.mapper;

import com.myschool.domain.dto.CourseRequest;
import com.myschool.domain.dto.CourseResponse;
import com.myschool.domain.entities.Courses;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {
    Courses dtoToEntity(CourseResponse courseResponse);
    Courses dtoToEntity(CourseRequest courseResponse);
    CourseResponse entityToDto(Courses courses);
}
