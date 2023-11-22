package com.myschool.service;

import com.myschool.domain.dto.CourseRequest;
import com.myschool.domain.dto.CourseResponse;
import com.myschool.domain.dto.InstituteRequest;
import com.myschool.domain.dto.UserProfileResponse;
import com.myschool.domain.entities.Courses;
import com.myschool.domain.entities.Institute;
import com.myschool.domain.entities.UserProfile;
import com.myschool.domain.mapper.CourseMapper;
import com.myschool.domain.mapper.InstituteMapper;
import com.myschool.domain.mapper.UserProfileMapper;
import com.myschool.domain.repository.ContactRepo;
import com.myschool.domain.repository.CourseRepo;
import com.myschool.domain.repository.InstituteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InstituteService {
    private final InstituteRepo instituteRepo;
    private final ContactRepo contactRepo;
    private final CourseRepo courseRepo;

    private final InstituteMapper instituteMapper;
    private final UserProfileMapper userProfileMapper;
    private final CourseMapper courseMapper;

    public void validateAndAdd(InstituteRequest request) {
        Institute institute = instituteMapper.dtoToEntity(request);
        if (institute.getOwnerUserId() == null) {
            return;
        }
        instituteRepo.save(instituteMapper.dtoToEntity(request));
    }

    public void validateAndAdd(CourseRequest request, UUID instituteId) {
        Courses courses = courseMapper.dtoToEntity(request);
        courses.setInstituteId(instituteId);
        courseRepo.save(courses);
    }

    public List<UserProfileResponse> getStudentsForInstitute(UUID instituteId) {
        List<UserProfile> students = instituteRepo.findStudentsByInstituteId(instituteId);

        return students.stream()
                .map(userProfileMapper::entityToDto)
                .toList();
    }

    public List<CourseResponse> getCoursesForInstitute(UUID instituteId) {
        List<Courses> courses = courseRepo.findByInstituteId(instituteId);

        return courses.stream()
                .map(courseMapper::entityToDto)
                .toList();
    }
}
