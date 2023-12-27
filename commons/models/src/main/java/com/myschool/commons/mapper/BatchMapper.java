package com.myschool.commons.mapper;

import com.myschool.commons.dto.console.AddBatch;
import com.myschool.commons.entities.Batch;
import org.mapstruct.Mapper;

@Mapper
public interface BatchMapper {
    Batch dtoToEntity(AddBatch addBatch);
}
