package com.myschool.manageops.domain.mapper;

import com.myschool.commons.dto.InstituteRequest;
import com.myschool.commons.dto.InstituteResponse;
import com.myschool.manageops.domain.entities.Institute;
import org.mapstruct.Mapper;

@Mapper
public interface InstituteMapper {
    Institute dtoToEntity(InstituteRequest instituteRequest);
    InstituteResponse entityToDto(Institute institute);
}
