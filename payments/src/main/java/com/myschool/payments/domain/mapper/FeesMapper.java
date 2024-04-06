package com.myschool.payments.domain.mapper;

import com.myschool.commons.dto.payments.AddFees;
import com.myschool.payments.domain.entities.FeesRecords;
import org.mapstruct.Mapper;

@Mapper
public interface FeesMapper {
    FeesRecords dtoToEntity(AddFees addFees);
}
