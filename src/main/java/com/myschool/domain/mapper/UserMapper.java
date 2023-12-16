package com.myschool.domain.mapper;

import com.myschool.domain.dto.UserRequest;
import com.myschool.domain.dto.UserResponse;
import com.myschool.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User dtoToEntity(UserRequest userRequest);

    User dtoToEntity(UserResponse userResponse);

    UserResponse entityToDto(User userProfile);
}
