package com.myschool.manageops.controller;

import com.myschool.commons.dto.AuthTokenResponse;
import com.myschool.commons.dto.LoginRequest;
import com.myschool.constants.Defaults;
import com.myschool.constants.endpoints.DashboardApi;
import com.myschool.manageops.auth.SessionService;
import com.myschool.manageops.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final ProfileService profileService;
    private final SessionService sessionService;

    @PostMapping(DashboardApi.USER_LOGIN)
    public ResponseEntity<AuthTokenResponse> userLogin(@RequestBody LoginRequest request) {
        UUID userId = profileService.getUser(request);
        AuthTokenResponse authTokenResponse = sessionService.getAuthToken(userId);
        HttpHeaders headers = new HttpHeaders();
        headers.add(Defaults.USER_TOKEN, authTokenResponse.getAuthToken());

        return ResponseEntity.ok()
                .headers(headers)
                .body(authTokenResponse);
    }

    @PostMapping(DashboardApi.USER_LOGOUT)
    public Boolean userLogout(ServerHttpRequest request) {
        return sessionService.logOutUser(request);
    }
}
