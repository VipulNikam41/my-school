package com.myschool.commons.domain.mapper;

import com.myschool.commons.domain.dto.InstituteRequest;
import com.myschool.commons.domain.dto.InstituteResponse;
import com.myschool.commons.domain.entities.Institute;
import org.mapstruct.Mapper;

@Mapper
public interface InstituteMapper {
    Institute dtoToEntity(InstituteRequest instituteRequest);
    InstituteResponse entityToDto(Institute institute);
}
