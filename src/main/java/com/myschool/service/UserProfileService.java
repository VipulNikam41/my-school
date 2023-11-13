package com.myschool.service;

import com.myschool.aspects.annotation.Loggable;
import com.myschool.domain.dto.UserProfileRequest;
import com.myschool.domain.entities.UserProfile;
import com.myschool.domain.mapper.UserProfileMapper;
import com.myschool.domain.repository.UserProfileRepo;
import com.myschool.domain.dto.UserProfileResponse;
import com.myschool.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepo userRepo;
    private final UserProfileMapper userMapper;

    @Loggable
    public UserProfileResponse getUserById(UUID id) {
        log.info("Returning user info for user {}", id);
        Optional<UserProfile> userProfile = userRepo.findById(id);

        if(userProfile.isEmpty()) {
            return null;
        }

        UserProfile user = userProfile.get();

        return userMapper.entityToDto(user);
    }

    public Boolean validateAndAdd(UserProfileRequest userDto) {
        userDto.setName(Utils.beautify(userDto.getName()));
        try {
            UserProfile user = userMapper.dtoToEntity(userDto);
            userRepo.save(user);
            log.info("User is saved {}", user.getId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean validateAndUpdate(UserProfileRequest user) {
        try {
            userRepo.save(userMapper.dtoToEntity(user));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
