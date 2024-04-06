package com.myschool.manageops.controller;

import com.myschool.commons.dto.AuthTokenResponse;
import com.myschool.commons.dto.LoginRequest;
import com.myschool.constants.Defaults;
import com.myschool.constants.endpoints.DashboardApi;
import com.myschool.manageops.auth.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final SessionService sessionService;

    @PostMapping(DashboardApi.USER_LOGIN)
    public ResponseEntity<AuthTokenResponse> userLogin(@RequestBody LoginRequest request) {
        AuthTokenResponse authTokenResponse = sessionService.getAuthToken(request);
        HttpHeaders headers = new HttpHeaders();
        headers.add(Defaults.USER_TOKEN, authTokenResponse.getAuthToken());

        return ResponseEntity.ok()
                .headers(headers)
                .body(authTokenResponse);
    }

    @PostMapping(DashboardApi.USER_LOGOUT)
    public Boolean userLogout(HttpServletRequest request) {
        return sessionService.logOutUser(request);
    }
}
