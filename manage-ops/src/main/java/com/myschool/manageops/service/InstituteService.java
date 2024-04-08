package com.myschool.manageops.service;

import com.myschool.commons.dto.*;
import com.myschool.commons.repository.ContactRepo;
import com.myschool.manageops.domain.entities.Course;
import com.myschool.manageops.domain.entities.Institute;
import com.myschool.manageops.domain.entities.Staff;
import com.myschool.manageops.eventpublisher.EventPublisher;
import com.myschool.manageops.domain.mapper.CourseMapper;
import com.myschool.manageops.domain.mapper.InstituteMapper;
import com.myschool.manageops.domain.mapper.StaffMapper;
import com.myschool.manageops.domain.repository.CourseRepo;
import com.myschool.manageops.domain.repository.InstituteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InstituteService {
    private final EventPublisher publish;

    private final ProfileService profileService;

    private final InstituteRepo instituteRepo;
    private final CourseRepo courseRepo;
    private final ContactRepo contactRepo;

    private final InstituteMapper instituteMapper;
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
        List<UUID> studentIds = instituteRepo.findStudentsIdsByInstituteId(instituteId);

        return profileService.getStudentByIdIn(studentIds);
    }

    public List<CourseResponse> getCoursesForInstitute(UUID instituteId) {
        List<Course> courses = courseRepo.findByInstituteId(instituteId);

        return courses.stream()
                .map(courseMapper::entityToDto)
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

        contactRepo.save(institute.getContact());
        instituteRepo.save(institute);
        publish.newInstituteEvent(institute.getId());
    }
}
