package com.myschool.payments.service;

import com.myschool.commons.dto.payments.AddSalary;
import com.myschool.payments.domain.entities.SalaryRecords;
import com.myschool.payments.domain.mapper.SalaryMapper;
import com.myschool.payments.domain.repository.SalaryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class SalaryService {
    private final SalaryRepo salaryRepo;
    private final SalaryMapper salaryMapper;

    public Boolean saveSalary(AddSalary addSalary) {
        SalaryRecords salaryRecords = salaryMapper.dtoToEntity(addSalary);
        if (salaryRecords.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }
        salaryRepo.save(salaryRecords);
        return true;
    }
}
