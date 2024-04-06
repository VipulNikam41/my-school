package com.myschool.manageops.service;

import com.myschool.manageops.domain.repository.InstituteRepo;
import com.myschool.manageops.domain.repository.StaffRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IdValidator {
    private final StaffRepo staffRepo;
    private final InstituteRepo instituteRepo;
    public boolean staffBelongsToInstitute(UUID instituteId, UUID... staffIds) {
        try {
            int numStaffIds = (int) Arrays.stream(staffIds).distinct().count();
            if (staffRepo.checkStaffBelongsToInstitute(instituteId, numStaffIds, staffIds)) {
                return true;
            }
        } catch (Exception e){
            // do thing
        }
        return false;
    }

    public boolean studentBelongsToInstitute(UUID instituteId, UUID... studentIds) {
        try {
            int numStudentIds = (int) Arrays.stream(studentIds).distinct().count();
            if (instituteRepo.checkStudentBelongsToInstitute(instituteId, numStudentIds, studentIds)) {
                return true;
            }
        } catch (Exception e){
            // do thing
        }
        return false;
    }
}
