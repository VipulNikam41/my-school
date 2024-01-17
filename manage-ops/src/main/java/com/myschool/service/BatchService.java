package com.myschool.service;

import com.myschool.commons.dto.BatchResponse;
import com.myschool.commons.dto.UserResponse;
import com.myschool.commons.dto.console.AddStudent;
import com.myschool.commons.dto.console.BatchRequest;
import com.myschool.constants.Defaults;
import com.myschool.constants.ResponseCode;
import com.myschool.manageops.entities.Batch;
import com.myschool.manageops.entities.BatchStudents;
import com.myschool.manageops.mapper.BatchMapper;
import com.myschool.manageops.repository.BatchRepo;
import com.myschool.manageops.repository.BatchStudentsRepo;
import com.myschool.utils.MathUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.myschool.utils.CollectionTool;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BatchService {
    private final InstituteService instituteService;
    private final UserService userService;

    private final BatchRepo batchRepo;
    private final BatchStudentsRepo batchStudentsRepo;

    private final BatchMapper batchMapper;

    public UUID validateAndAdd(BatchRequest batchRequest, UUID instituteId) {
        Batch batch = batchMapper.dtoToEntity(batchRequest);
        batch.setInstituteId(instituteId);

        if (MathUtil.isNegative(batch.getBatchSize()) || MathUtil.isNegative(batch.getFees())) {
            return null;
        }

        batchRepo.save(batch);
        return batch.getId();
    }

    public ResponseCode addStudent(AddStudent student, UUID instituteId) {
        if (student.getBatchId() == null) {
            return ResponseCode.DATA_200;
        }

        Batch batch = batchRepo.findByIdAndInstituteId(student.getBatchId(), instituteId);
        if (batch == null) {
            return ResponseCode.DATA_200;
        }

        List<UserResponse> users = userService.getStudentByContact(student.getContact().getEmail(), student.getContact().getPhoneNumber());
        if (!CollectionTool.isEmpty(users)) {
            return ResponseCode.NOTIFY_100;
        }

        UUID studentId = userService.validateAndAdd(student);

        BatchStudents batchStudents = new BatchStudents();
        batchStudents.setBatchId(student.getBatchId());
        batchStudents.setStudentId(studentId);
        batchStudents.setDiscountedFees(student.getDiscountedFees());
        batchStudentsRepo.save(batchStudents);
        // what if save fails? somehow need to roll back TODO

        return ResponseCode.SUCCESSFUL_100;
    }

    public List<BatchResponse> getBatches(UUID instituteId, List<UUID> batchIds) {
        List<Batch> batches;
        if (!CollectionTool.isEmpty(batchIds)) {
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
        if(batchId == null && studentIds == null) {
            return instituteService.getStudentsForInstitute(instituteId);
        }

        Batch batch = batchRepo.findByIdAndInstituteId(batchId, instituteId);
        if (batch == null) {
            return null;
        }

        return userService.getStudentByIdIn(studentIds);
    }

    public Boolean updateStudent(AddStudent request, UUID instituteId, UUID batchId, UUID studentId) {
        Batch batch = batchRepo.findByIdAndInstituteId(batchId, instituteId);
        if (batch == null) {
            return false;
        }

        return userService.validateAndUpdate(request, studentId);
    }

    public void addDefaultBranch(UUID instituteId) {
        if(instituteId == null) {
            return;
        }

        Batch batch = new Batch();
        batch.setId(instituteId);
        batch.setName(Defaults.BATCH_NAME);
        batch.setDescription(Defaults.BATCH_NAME);
        batch.setInstituteId(instituteId);
        batchRepo.save(batch);
    }
}
