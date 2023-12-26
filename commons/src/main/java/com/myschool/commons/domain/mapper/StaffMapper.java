package com.myschool.commons.domain.mapper;

import com.myschool.commons.domain.dto.StaffResponse;
import com.myschool.commons.domain.dto.console.OwnerRegistrationRequest;
import com.myschool.commons.domain.dto.StaffRequest;
import com.myschool.commons.domain.entities.Staff;
import org.mapstruct.Mapper;

@Mapper
public interface StaffMapper {
    Staff dtoToEntity(StaffResponse staffResponse);
    Staff dtoToEntity(StaffRequest request);

    Staff dtoToEntity(OwnerRegistrationRequest staffResponse);

    StaffResponse entityToDto(Staff staff);
}
