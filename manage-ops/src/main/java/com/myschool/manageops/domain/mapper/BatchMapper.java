package com.myschool.manageops.domain.mapper;

import com.myschool.commons.dto.BatchResponse;
import com.myschool.commons.dto.console.BatchRequest;
import com.myschool.manageops.domain.entities.Batch;
import org.mapstruct.Mapper;

@Mapper
public interface BatchMapper {
    Batch dtoToEntity(BatchRequest batchRequest);

    BatchResponse entityToDto(Batch batch);
}
