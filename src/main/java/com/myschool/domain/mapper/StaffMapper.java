package com.myschool.domain.mapper;

import com.myschool.domain.dto.StaffResponse;
import com.myschool.domain.entities.Staff;
import org.mapstruct.Mapper;

@Mapper
public interface StaffMapper {
    Staff dtoToEntity(StaffResponse staffResponse);

    StaffResponse entityToDto(Staff staff);
}
