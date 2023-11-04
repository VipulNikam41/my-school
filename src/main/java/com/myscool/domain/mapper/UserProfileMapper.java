package com.myscool.domain.mapper;

import com.myscool.domain.dto.UserProfileDTO;
import com.myscool.domain.entities.UserProfile;
import org.mapstruct.Mapper;

@Mapper
public interface UserProfileMapper {
    UserProfile dtoToEntity(UserProfileDTO instituteDTO);

    UserProfileDTO entityToDto(UserProfile institute);
}
