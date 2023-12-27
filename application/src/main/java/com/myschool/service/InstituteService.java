package com.myschool.service;

import com.myschool.commons.dto.*;
import com.myschool.commons.entities.Course;
import com.myschool.commons.entities.Institute;
import com.myschool.commons.entities.Staff;
import com.myschool.commons.entities.User;
import com.myschool.commons.mapper.CourseMapper;
import com.myschool.commons.mapper.InstituteMapper;
import com.myschool.commons.mapper.StaffMapper;
import com.myschool.commons.mapper.UserMapper;
import com.myschool.commons.repository.CourseRepo;
import com.myschool.commons.repository.InstituteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InstituteService {
    private final InstituteRepo instituteRepo;
    private final CourseRepo courseRepo;

    private final InstituteMapper instituteMapper;
    private final UserMapper userMapper;
    private final StaffMapper staffMapper;
    private final CourseMapper courseMapper;

    public void validateAndAdd(InstituteRequest request) {
        this.validateAndAdd(request, null);
    }

    public void validateAndAdd(CourseRequest request, UUID instituteId) {
        Course course = courseMapper.dtoToEntity(request);
        course.setInstituteId(instituteId);
        courseRepo.save(course);
    }

    public List<UserResponse> getStudentsForInstitute(UUID instituteId) {
        List<User> students = instituteRepo.findStudentsByInstituteId(instituteId);

        return students.stream()
                .map(userMapper::entityToDto)
                .toList();
    }

    public List<CourseResponse> getCoursesForInstitute(UUID instituteId) {
        List<Course> courses = courseRepo.findByInstituteId(instituteId);

        return courses.stream()
                .map(courseMapper::entityToDto)
                .toList();
    }

    public List<UserResponse> getStudentsForCourse(UUID instituteId, UUID courseId) {
        Course course = courseRepo.findById(courseId).orElse(null);

        if (course == null || !course.getInstituteId().equals(instituteId)) {
            return Collections.emptyList();
        }

        List<User> students = instituteRepo.findStudentsByCourseId(courseId);

        return students.stream()
                .map(userMapper::entityToDto)
                .toList();
    }

    public List<StaffResponse> getInstructorsForInstitute(UUID instituteId) {
        List<Staff> instructors = instituteRepo.findInstructorsByInstituteId(instituteId);

        return instructors.stream()
                .map(staffMapper::entityToDto)
                .toList();
    }

    public void validateAndAdd(InstituteRequest request, UUID homeInstiId) {
        Institute institute = instituteMapper.dtoToEntity(request);
        if (institute.getOwnerId() == null) {
            return;
        }

        if (homeInstiId != null) {
            Institute currInstitute = instituteRepo.findById(homeInstiId).orElse(null);
            if (currInstitute == null) {
                return;
            }
            if (currInstitute.isSubBranch()) {
                homeInstiId = currInstitute.getHomeBranchId();
            }
            institute.setHomeBranchId(homeInstiId);
        }

        instituteRepo.save(institute);
    }
}
