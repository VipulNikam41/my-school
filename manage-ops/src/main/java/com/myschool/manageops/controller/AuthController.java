package com.myschool.manageops.controller;

import com.myschool.commons.dto.AuthTokenResponse;
import com.myschool.commons.dto.LoginRequest;
import com.myschool.constants.endpoints.DashboardApi;
import com.myschool.manageops.auth.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final SessionService sessionService;

    @PostMapping(DashboardApi.USER_LOGIN)
    public AuthTokenResponse userLogin(@RequestBody LoginRequest request) {
        return sessionService.getAuthToken(request);
    }

    @PostMapping(DashboardApi.USER_LOGOUT)
    public Boolean userLogout(HttpServletRequest request) {
        return sessionService.logOutUser(request);
    }
}
