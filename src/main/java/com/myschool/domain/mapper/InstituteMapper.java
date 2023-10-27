package com.myschool.domain.mapper;

import com.myschool.domain.dto.InstituteDTO;
import com.myschool.domain.entities.Institute;
import org.mapstruct.Mapper;

@Mapper
public interface InstituteMapper {
    Institute dtoToEntity(InstituteDTO instituteDTO);
    InstituteDTO entityToDto(Institute institute);
}
