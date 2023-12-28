package com.myschool.service;

import com.myschool.commons.dto.console.AddStudent;
import com.myschool.commons.entities.Batch;
import com.myschool.commons.entities.BatchStudents;
import com.myschool.commons.entities.User;
import com.myschool.commons.mapper.UserMapper;
import com.myschool.commons.repository.BatchRepo;
import com.myschool.commons.repository.BatchStudentsRepo;
import com.myschool.commons.repository.UserRepo;
import com.myschool.constants.ResponseCode;
import com.myschool.constants.UserRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdmissionService {
    private final BatchRepo batchRepo;
    private final UserRepo userRepo;
    private final BatchStudentsRepo batchStudentsRepo;

    private final UserMapper userMapper;

    public ResponseCode addStudent(AddStudent student, UUID instituteId) {
        if (student == null || student.getBatchId() == null) {
            return ResponseCode.DATA_200;
        }

        Batch batch = batchRepo.findByIdAndInstituteId(student.getBatchId(), instituteId);
        if (batch == null) {
            return ResponseCode.DATA_200;
        }

        User user1 = this.getStudentByContact(student.getContact().getEmail(), student.getContact().getPhoneNumber());
        if (user1 != null) {
            log.info("user with given email or phone number already exist, need to send notification to user");
            return ResponseCode.NOTIFY_100;
        }

        User user = userMapper.dtoToEntity(student);
        user.setPrimaryGoal(UserRole.STUDENT);
        userRepo.save(user);

        BatchStudents batchStudents = new BatchStudents();
        batchStudents.setBatchId(student.getBatchId());
        batchStudents.setStudentId(user.getId());
        batchStudents.setDiscountedFees(student.getDiscountedFees());
        batchStudentsRepo.save(batchStudents);

        return ResponseCode.SUCCESSFUL_100;
    }

    private User getStudentByContact(String email, String phoneNumber) {
        return userRepo.getUserByContact(email, phoneNumber).stream()
                .filter(user ->
                        user.getContact().isEmailVerified() ||
                        user.getContact().isPhoneNumberVerified()
                ).findFirst()
                .orElse(null);
    }

    public ResponseCode addExistingStudent(AddStudent student, UUID instituteId) {
        if (student == null || student.getBatchId() == null) {
            return ResponseCode.DATA_200;
        }

        Batch batch = batchRepo.findByIdAndInstituteId(student.getBatchId(), instituteId);
        if (batch == null) {
            return ResponseCode.DATA_200;
        }

        User user1 = this.getStudentByContact(student.getContact().getEmail(), student.getContact().getPhoneNumber());
        if (user1 == null) {
            return ResponseCode.FAILURE_200;
        }

        User user = userMapper.dtoToEntity(student);
        user.setPrimaryGoal(UserRole.STUDENT);
        userRepo.save(user);

        BatchStudents batchStudents = new BatchStudents();
        batchStudents.setBatchId(student.getBatchId());
        batchStudents.setStudentId(user.getId());
        batchStudents.setDiscountedFees(student.getDiscountedFees());
        batchStudentsRepo.save(batchStudents);

        return ResponseCode.SUCCESSFUL_100;
    }
}
