package com.myschool.service;

import com.myschool.constants.Privilege;
import com.myschool.constants.StaffRole;
import com.myschool.commons.dto.InstituteResponse;
import com.myschool.commons.dto.console.OwnerRegistrationRequest;
import com.myschool.commons.dto.StaffRequest;
import com.myschool.commons.entities.Institute;
import com.myschool.commons.entities.Staff;
import com.myschool.commons.mapper.InstituteMapper;
import com.myschool.commons.mapper.StaffMapper;
import com.myschool.commons.repository.InstituteRepo;
import com.myschool.commons.repository.StaffRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StaffService {
    private final StaffRepo staffRepo;
    private final InstituteRepo instituteRepo;

    private final InstituteMapper instituteMapper;
    private final StaffMapper staffMapper;

    public Boolean addOwner(OwnerRegistrationRequest request) {
        Staff owner = staffMapper.dtoToEntity(request);
        List<Privilege> privileges = List.of(Privilege.ADMIN);
        owner.setPrivileges(privileges);
        owner.setPrimaryGoal(StaffRole.OWNER);

        staffRepo.save(owner);

        return true;
    }

    public List<InstituteResponse> getInstitutesOwnedByUser(UUID id) {
        List<Institute> institutes = instituteRepo.findAllByOwnerId(id);

        if (CollectionUtils.isEmpty(institutes)) {
            return Collections.emptyList();
        }

        UUID homeBranch = institutes.stream()
                .filter(i -> i.getHomeBranchId() != null)
                .map(Institute::getHomeBranchId)
                .findFirst().orElse(null);

        if(homeBranch!=null) {
            List<Institute> subInstitutes = instituteRepo.findAllByHomeBranchId(homeBranch);
            institutes.addAll(subInstitutes);
        }

        return institutes.stream()
                .map(instituteMapper::entityToDto)
                .toList();
    }

    public Boolean onboardStaff(StaffRequest request) {
        Staff staff = staffMapper.dtoToEntity(request);
        staffRepo.save(staff);
        return true;
    }
}
