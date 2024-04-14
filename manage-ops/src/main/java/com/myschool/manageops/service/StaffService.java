package com.myschool.manageops.service;

import com.myschool.commons.dto.InstituteResponse;
import com.myschool.commons.dto.LoginRequest;
import com.myschool.commons.dto.StaffRequest;
import com.myschool.commons.dto.console.OwnerRegistrationRequest;
import com.myschool.constants.Privilege;
import com.myschool.constants.StaffRole;
import com.myschool.manageops.domain.entities.Institute;
import com.myschool.manageops.domain.entities.Staff;
import com.myschool.manageops.domain.entities.StaffCredentials;
import com.myschool.manageops.domain.mapper.InstituteMapper;
import com.myschool.manageops.domain.mapper.StaffMapper;
import com.myschool.manageops.domain.repository.InstituteRepo;
import com.myschool.manageops.domain.repository.StaffCredentialsRepo;
import com.myschool.manageops.domain.repository.StaffRepo;
import com.myschool.manageops.utils.PasswordUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class StaffService {
    private final StaffRepo staffRepo;
    private final StaffCredentialsRepo staffCredentialsRepo;
    private final InstituteRepo instituteRepo;

    private final InstituteMapper instituteMapper;
    private final StaffMapper staffMapper;

    public UUID getStaffId(LoginRequest loginRequest) {
        if (loginRequest.getInstituteId() == null) {
            return null;
        }
        Optional<Staff> staff;
        if (loginRequest.getEmailId() != null) {
            staff = staffRepo.findByContactEmailAndInstituteId(loginRequest.getEmailId(), loginRequest.getInstituteId());
        } else {
            staff = staffRepo.findByContactPhoneNumberAndInstituteId(loginRequest.getPhoneNumber(), loginRequest.getInstituteId());
        }
        if (staff.isEmpty()) {
            return null;
        }

        UUID staffId = staff.get().getId();

        StaffCredentials credentials = staffCredentialsRepo.findById(staffId).orElse(null);
        if (credentials == null || !PasswordUtil.matchPassword(loginRequest.getPassword(), credentials.getPassword())) {
            return null;
        }
        return staffId;
    }
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
                .map(Institute::getHomeBranchId)
                .filter(Objects::nonNull)
                .findFirst().orElse(null);

        if (homeBranch != null) {
            List<Institute> subInstitutes = instituteRepo.findAllByHomeBranchId(homeBranch);
            institutes.addAll(subInstitutes);
        }

        return institutes.stream()
                .map(instituteMapper::entityToDto)
                .toList();
    }

    public Boolean onboardStaff(StaffRequest request, UUID instituteId) {
        Staff staff = staffMapper.dtoToEntity(request);
        staff.setInstituteId(instituteId);
        staffRepo.save(staff);
        return true;
    }

    public Boolean updateStaff(StaffRequest request, UUID instituteId, UUID staffId) {
        Staff staff = staffRepo.findById(staffId).orElse(null);
        if (staff == null || staff.getInstituteId() != instituteId) {
            return false;
        }
        staff = staffMapper.dtoToEntity(request);
        staff.setInstituteId(instituteId);

        staffRepo.save(staff);
        return true;
    }
}
