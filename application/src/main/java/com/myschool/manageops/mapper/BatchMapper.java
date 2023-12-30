package com.myschool.manageops.mapper;

import com.myschool.commons.dto.console.AddBatch;
import com.myschool.manageops.entities.Batch;
import org.mapstruct.Mapper;

@Mapper
public interface BatchMapper {
    Batch dtoToEntity(AddBatch addBatch);
}
