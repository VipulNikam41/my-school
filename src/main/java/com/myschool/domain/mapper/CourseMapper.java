package com.myschool.domain.mapper;

import com.myschool.domain.dto.CourseRequest;
import com.myschool.domain.dto.CourseResponse;
import com.myschool.domain.entities.Course;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {
    Course dtoToEntity(CourseResponse courseResponse);
    Course dtoToEntity(CourseRequest courseResponse);
    CourseResponse entityToDto(Course courses);
}
