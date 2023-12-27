package com.myschool.commons.mapper;

import com.myschool.commons.dto.StaffResponse;
import com.myschool.commons.dto.console.OwnerRegistrationRequest;
import com.myschool.commons.dto.StaffRequest;
import com.myschool.commons.entities.Staff;
import org.mapstruct.Mapper;

@Mapper
public interface StaffMapper {
    Staff dtoToEntity(StaffResponse staffResponse);

    Staff dtoToEntity(StaffRequest request);

    Staff dtoToEntity(OwnerRegistrationRequest staffResponse);

    StaffResponse entityToDto(Staff staff);
}
