package com.myscool.service;

import com.myscool.aspects.annotation.Loggable;
import com.myscool.domain.dto.UserProfileDTO;
import com.myscool.domain.entities.UserProfile;
import com.myscool.domain.mapper.UserProfileMapper;
import com.myscool.domain.repository.UserProfileRepo;
import com.myscool.response.GetUserResponse;
import com.myscool.utils.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserProfileService {
    @Autowired
    private UserProfileRepo userRepo;
    @Autowired
    private UserProfileMapper userMapper;

    @Loggable
    public GetUserResponse getUserById(UUID id) {
        GetUserResponse getUserResponse = new GetUserResponse();
        Optional<UserProfile> userProfile = userRepo.findById(id);

        getUserResponse.setUserProfileDTO(userMapper.entityToDto(userProfile.orElse(null)));
        return getUserResponse;
    }

    public Boolean validateAndAdd(UserProfileDTO userDto) {
        userDto.setName(Utility.beautify(userDto.getName()));
        try {
            UserProfile user = userMapper.dtoToEntity(userDto);
            userRepo.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean validateAndUpdate(UserProfileDTO user) {
        try {
            userRepo.save(userMapper.dtoToEntity(user));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
