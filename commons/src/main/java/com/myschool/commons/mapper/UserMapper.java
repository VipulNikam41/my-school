package com.myschool.commons.mapper;

import com.myschool.commons.dto.UserRequest;
import com.myschool.commons.dto.UserResponse;
import com.myschool.commons.dto.console.AddStudent;
import com.myschool.commons.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User dtoToEntity(UserRequest userRequest);

    User dtoToEntity(UserResponse userResponse);

    UserResponse entityToDto(User userProfile);

    User dtoToEntity(AddStudent student);
}
