package com.myschool.manageops.domain.mapper;

import com.myschool.commons.dto.CourseRequest;
import com.myschool.commons.dto.CourseResponse;
import com.myschool.manageops.domain.entities.Course;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {
    Course dtoToEntity(CourseResponse courseResponse);
    Course dtoToEntity(CourseRequest courseResponse);
    CourseResponse entityToDto(Course courses);
}
