package com.myschool.manageops.service;

import com.myschool.commons.dto.BatchResponse;
import com.myschool.commons.dto.UserResponse;
import com.myschool.commons.dto.console.AddStudent;
import com.myschool.commons.dto.console.BatchRequest;
import com.myschool.constants.Defaults;
import com.myschool.constants.ResponseCode;
import com.myschool.constants.event.Situation;
import com.myschool.manageops.domain.entities.Batch;
import com.myschool.manageops.domain.entities.BatchStudents;
import com.myschool.manageops.domain.entities.User;
import com.myschool.manageops.domain.mapper.BatchMapper;
import com.myschool.manageops.domain.mapper.UserMapper;
import com.myschool.manageops.domain.repository.BatchRepo;
import com.myschool.manageops.domain.repository.BatchStudentsRepo;
import com.myschool.manageops.event.EventPublisher;
import com.myschool.utils.MathUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BatchService {
    private final InstituteService instituteService;
    private final ProfileService profileService;

    private final BatchRepo batchRepo;
    private final BatchStudentsRepo batchStudentsRepo;

    private final BatchMapper batchMapper;
    private final UserMapper userMapper;

    private final EventPublisher eventPublisher;

    public UUID validateAndAdd(BatchRequest batchRequest, UUID instituteId) {
        Batch batch = batchMapper.dtoToEntity(batchRequest);
        batch.setInstituteId(instituteId);

        if (MathUtil.isNegative(batch.getBatchSize()) || MathUtil.isNegative(batch.getFees())) {
            return null;
        }

        batchRepo.save(batch);
        return batch.getId();
    }

    @Transactional(rollbackOn = Exception.class)
    public ResponseCode addStudent(AddStudent student, UUID instituteId) {
        if (student.getBatchId() == null) {
            student.setBatchId(instituteId);
        }

        Batch batch = batchRepo.findByIdAndInstituteId(student.getBatchId(), instituteId);
        if (batch == null) {
            return ResponseCode.DATA_200;
        }

        List<User> users = profileService.getStudentByContactForInstitute(student.getUser().getContact().getEmail(), student.getUser().getContact().getPhoneNumber(), instituteId);
        if (!CollectionUtils.isEmpty(users)) {
            return ResponseCode.NOTIFY_100;
        }

        UUID studentId = profileService.registerUser(student.getUser()).getId();
        if (studentId == null) {
            return ResponseCode.FAILURE_200;
        }

        BatchStudents batchStudents = new BatchStudents();
        batchStudents.setBatchId(student.getBatchId());
        batchStudents.setStudentId(studentId);
        batchStudents.setDiscountedFees(student.getDiscountedFees());
        batchStudentsRepo.save(batchStudents);

        return ResponseCode.SUCCESSFUL_100;
    }

    public List<BatchResponse> getBatches(UUID instituteId, List<UUID> batchIds) {
        List<Batch> batches;
        if (!CollectionUtils.isEmpty(batchIds)) {
            batches = batchRepo.findAllById(batchIds);
            batches = batches.stream().filter(b -> b.getInstituteId() != instituteId).toList();
        } else {
            batches = batchRepo.findByInstituteId(instituteId);
        }

        return batches.stream()
                .map(batchMapper::entityToDto)
                .toList();
    }

    public Boolean updateBatch(BatchRequest request, UUID instituteId, UUID batchId) {
        Batch batch = batchRepo.findById(batchId).orElse(null);
        if (batch == null || batch.getInstituteId() != instituteId) {
            return false;
        }
        batch = batchMapper.dtoToEntity(request);
        batch.setId(batchId);

        batchRepo.save(batch);
        return true;
    }

    public List<UserResponse> getStudents(UUID instituteId, UUID batchId, List<UUID> studentIds) {
        if (batchId == null && studentIds == null) {
            return instituteService.getStudentsForInstitute(instituteId);
        }

        Batch batch = batchRepo.findByIdAndInstituteId(batchId, instituteId);
        if (batch == null) {
            return null;
        }

        return profileService.getStudentByIdIn(studentIds);
    }

    public Boolean updateStudent(AddStudent request, UUID instituteId, UUID batchId, UUID studentId) {
        Batch batch = batchRepo.findByIdAndInstituteId(batchId, instituteId);
        if (batch == null) {
            return false;
        }

        return profileService.validateAndUpdate(request, studentId);
    }

    public void addDefaultBranch(UUID instituteId) {
        if (instituteId == null) {
            return;
        }

        Batch batch = new Batch();
        batch.setId(instituteId);
        batch.setName(Defaults.BATCH_NAME);
        batch.setDescription(Defaults.BATCH_NAME);
        batch.setInstituteId(instituteId);
        batch.setFees(BigDecimal.valueOf(0));
        batch.setBatchSize(-1);
        batchRepo.save(batch);
    }

    public List<UserResponse> getStudentsByContact(String emailId, String phoneNumber) {
        List<User> users = profileService.getStudentByContact(emailId, phoneNumber);
        List<User> verifiedUser = users.stream().filter(
                user -> user.getContact().isEmailVerified() || user.getContact().isPhoneNumberVerified()
        ).toList();
        if (!verifiedUser.isEmpty()) {
            if (verifiedUser.size() != 1) {
                eventPublisher.publishSystemMonitorEvent(
                        this.getClass(),
                        "getStudentsByContact",
                        verifiedUser.size() + " verified users found for email: " + emailId + " phone: " + phoneNumber,
                        Situation.DB_DISCREPANCY
                );
            }
            return verifiedUser.stream()
                    .map(userMapper::entityToDto)
                    .toList();
        }
        return users.stream()
                .map(userMapper::entityToDto)
                .toList();
    }
}
