package com.myschool.commons.domain.mapper;

import com.myschool.commons.domain.dto.CourseResponse;
import com.myschool.commons.domain.dto.CourseRequest;
import com.myschool.commons.domain.entities.Course;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {
    Course dtoToEntity(CourseResponse courseResponse);
    Course dtoToEntity(CourseRequest courseResponse);
    CourseResponse entityToDto(Course courses);
}
