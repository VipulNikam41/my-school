package com.myschool.syllabushub.service;

import com.myschool.commons.dto.syllabushub.AddBaCoIn;
import com.myschool.syllabushub.domain.entities.BatchCourseInstructor;
import com.myschool.syllabushub.domain.mapper.BaCoInMapper;
import com.myschool.syllabushub.domain.repository.BaCoInRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BaCoInService {
    private final BaCoInRepo baCoInRepo;
    private final BaCoInMapper baCoInMapper;

    public UUID addBaCoIn(AddBaCoIn baCoIn) {
        if (baCoIn.getBatchId() == null && baCoIn.getInstructorId() == null && baCoIn.getCourseId() == null) {
            return null;
        }
        BatchCourseInstructor batchCourseInstructor = baCoInMapper.dtoToEntity(baCoIn);
        baCoInRepo.save(batchCourseInstructor);
        return batchCourseInstructor.getId();
    }
}
