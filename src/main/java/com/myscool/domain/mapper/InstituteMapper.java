package com.myscool.domain.mapper;

import com.myscool.domain.dto.InstituteDTO;
import com.myscool.domain.entities.Institute;
import org.mapstruct.Mapper;

@Mapper
public interface InstituteMapper {
    Institute dtoToEntity(InstituteDTO instituteDTO);
    InstituteDTO entityToDto(Institute institute);
}
