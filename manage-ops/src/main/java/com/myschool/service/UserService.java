package com.myschool.service;

import com.myschool.aspects.annotation.Loggable;
import com.myschool.commons.dto.UserResponse;
import com.myschool.commons.dto.console.AddStudent;
import com.myschool.constants.endpoints.DashboardApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static com.myschool.constants.MicroService.USER_DASHBOARD;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final WebClient.Builder webClientBuilder;

    @Loggable
    public UserResponse getUserById(UUID id) {
        return webClientBuilder.build().get()
                .uri(USER_DASHBOARD.getService() + DashboardApi.GET_PROFILE.replace("{userId}", id.toString()))
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();
    }

    public UUID validateAndAdd(AddStudent addStudent) {
        // DashboardApi.AddProfile TODO add user
        return UUID.randomUUID();
    }

    public Boolean validateAndUpdate(AddStudent user, UUID id) {
        // DashboardApi.UPDATE_PROFILE TODO update user
        return true;
    }

    public List<UserResponse> getStudentByContact(String email, String phoneNumber) {
        // need to write api to get student by contact TODO

        return Collections.emptyList();
    }

    public List<UserResponse> getStudentByIdIn(List<UUID> studentIds) {
        return null;
    }
}
