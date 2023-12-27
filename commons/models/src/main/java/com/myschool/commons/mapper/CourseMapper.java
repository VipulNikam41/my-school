package com.myschool.commons.mapper;

import com.myschool.commons.dto.CourseRequest;
import com.myschool.commons.dto.CourseResponse;
import com.myschool.commons.entities.Course;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {
    Course dtoToEntity(CourseResponse courseResponse);
    Course dtoToEntity(CourseRequest courseResponse);
    CourseResponse entityToDto(Course courses);
}
