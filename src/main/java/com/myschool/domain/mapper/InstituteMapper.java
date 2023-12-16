package com.myschool.domain.mapper;

import com.myschool.domain.dto.InstituteRequest;
import com.myschool.domain.dto.InstituteResponse;
import com.myschool.domain.entities.Institute;
import org.mapstruct.Mapper;

@Mapper
public interface InstituteMapper {
    Institute dtoToEntity(InstituteRequest instituteRequest);
    InstituteResponse entityToDto(Institute institute);
}
