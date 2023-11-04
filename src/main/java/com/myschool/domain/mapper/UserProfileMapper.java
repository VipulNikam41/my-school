package com.myschool.domain.mapper;

import com.myschool.domain.dto.UserProfileDTO;
import com.myschool.domain.entities.UserProfile;
import org.mapstruct.Mapper;

@Mapper
public interface UserProfileMapper {
    UserProfile dtoToEntity(UserProfileDTO instituteDTO);

    UserProfileDTO entityToDto(UserProfile institute);
}
