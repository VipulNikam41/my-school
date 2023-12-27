package com.myschool.service;

import com.myschool.constants.ResponseCode;
import com.myschool.constants.UserRole;
import com.myschool.commons.dto.console.AddBatch;
import com.myschool.commons.dto.console.AddStudent;
import com.myschool.commons.entities.Batch;
import com.myschool.commons.entities.BatchStudents;
import com.myschool.commons.entities.User;
import com.myschool.commons.mapper.BatchMapper;
import com.myschool.commons.mapper.UserMapper;
import com.myschool.commons.repository.BatchRepo;
import com.myschool.commons.repository.BatchStudentsRepo;
import com.myschool.commons.repository.UserRepo;
import com.myschool.utils.MathUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BatchService {
    private final UserService userService;

    private final BatchRepo batchRepo;
    private final UserRepo userRepo;
    private final BatchStudentsRepo batchStudentsRepo;

    private final BatchMapper batchMapper;
    private final UserMapper userMapper;

    public UUID validateAndAdd(AddBatch batchRequest, UUID instituteId) {
        Batch batch = batchMapper.dtoToEntity(batchRequest);
        batch.setInstituteId(instituteId);

        if(MathUtil.isNegative(batch.getBatchSize()) || MathUtil.isNegative(batch.getFees())) {
            return null;
        }

        batchRepo.save(batch);
        return batch.getId();
    }

    public ResponseCode addStudent(AddStudent student, UUID instituteId) {
        if(student.getBatchId() == null) {
            return ResponseCode.DATA_200;
        }

        Batch batch = batchRepo.findByIdAndInstituteId(student.getBatchId(), instituteId);
        if(batch == null) {
            return ResponseCode.DATA_200;
        }


        List<User> users = userService.getStudentByContact(student.getContact().getEmail(), student.getContact().getPhoneNumber());
        if(!CollectionUtils.isEmpty(users)) {
            return ResponseCode.NOTIFY_100;
        }

        User user = userMapper.dtoToEntity(student);
        userRepo.save(user);

        BatchStudents batchStudents = new BatchStudents();
        batchStudents.setBatchId(student.getBatchId());
        batchStudents.setStudentId(user.getId());
        batchStudents.setDiscountedFees(student.getDiscountedFees());
        batchStudentsRepo.save(batchStudents);

        user.setPrimaryGoal(UserRole.STUDENT);
        return ResponseCode.SUCCESSFUL_100;
    }
}
