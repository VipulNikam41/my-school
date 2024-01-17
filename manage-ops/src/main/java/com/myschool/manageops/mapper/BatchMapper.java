package com.myschool.manageops.mapper;

import com.myschool.commons.dto.BatchResponse;
import com.myschool.commons.dto.console.BatchRequest;
import com.myschool.manageops.entities.Batch;
import org.mapstruct.Mapper;

@Mapper
public interface BatchMapper {
    Batch dtoToEntity(BatchRequest batchRequest);

    BatchResponse entityToDto(Batch batch);
}
