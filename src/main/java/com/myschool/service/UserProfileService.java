package com.myschool.service;

import com.myschool.aspects.annotation.Loggable;
import com.myschool.domain.dto.UserProfileDTO;
import com.myschool.domain.entities.UserProfile;
import com.myschool.domain.mapper.UserProfileMapper;
import com.myschool.domain.repository.UserProfileRepo;
import com.myschool.response.GetUserResponse;
import com.myschool.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserProfileService {
    @Autowired
    private UserProfileRepo userRepo;
    @Autowired
    private UserProfileMapper userMapper;

    @Loggable
    public GetUserResponse getUserById(UUID id) {
        log.info("Returning user info for user " + id);
        GetUserResponse getUserResponse = new GetUserResponse();
        Optional<UserProfile> userProfile = userRepo.findById(id);

        getUserResponse.setUserProfileDTO(userMapper.entityToDto(userProfile.orElse(null)));
        return getUserResponse;
    }

    public Boolean validateAndAdd(UserProfileDTO userDto) {
        userDto.setName(Utils.beautify(userDto.getName()));
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
