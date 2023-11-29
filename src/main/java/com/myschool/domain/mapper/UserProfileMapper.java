package com.myschool.domain.mapper;

import com.myschool.domain.dto.UserProfileRequest;
import com.myschool.domain.dto.UserProfileResponse;
import com.myschool.domain.entities.UserProfile;
import org.mapstruct.Mapper;

@Mapper
public interface UserProfileMapper {
    UserProfile dtoToEntity(UserProfileRequest userProfileRequest);
    UserProfile dtoToEntity(UserProfileResponse userProfileResponse);

    UserProfileResponse entityToDto(UserProfile userProfile);
}
