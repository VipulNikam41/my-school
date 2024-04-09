package com.myschool.payments.domain.mapper;

import com.myschool.commons.dto.payments.AddSalary;
import com.myschool.payments.domain.entities.SalaryRecords;
import org.mapstruct.Mapper;

@Mapper
public interface SalaryMapper {
    SalaryRecords dtoToEntity(AddSalary salary);
}
