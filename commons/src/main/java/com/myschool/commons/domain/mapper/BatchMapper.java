package com.myschool.commons.domain.mapper;

import com.myschool.commons.domain.dto.console.AddBatch;
import com.myschool.commons.domain.entities.Batch;
import org.mapstruct.Mapper;

@Mapper
public interface BatchMapper {
    Batch dtoToEntity(AddBatch addBatch);
}
