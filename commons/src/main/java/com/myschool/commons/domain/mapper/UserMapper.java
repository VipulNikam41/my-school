package com.myschool.commons.domain.mapper;

import com.myschool.commons.domain.dto.UserRequest;
import com.myschool.commons.domain.dto.UserResponse;
import com.myschool.commons.domain.dto.console.AddStudent;
import com.myschool.commons.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User dtoToEntity(UserRequest userRequest);

    User dtoToEntity(UserResponse userResponse);

    UserResponse entityToDto(User userProfile);

    User dtoToEntity(AddStudent student);
}
