package com.myschool.payments.service;

import com.myschool.commons.dto.payments.AddFees;
import com.myschool.payments.domain.entities.FeesRecords;
import com.myschool.payments.domain.mapper.FeesMapper;
import com.myschool.payments.domain.repository.FeesRecordRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class FeesService {
    private final FeesRecordRepo feesRecordRepo;
    private final FeesMapper feesMapper;

    public Boolean saveExpense(AddFees addFees) {
        FeesRecords records = feesMapper.dtoToEntity(addFees);
        if (records.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }
        feesRecordRepo.save(records);
        return true;
    }
}
