package com.myschool.manageops.controller.console;

import com.myschool.commons.dto.AuthTokenResponse;
import com.myschool.commons.dto.LoginRequest;
import com.myschool.constants.Defaults;
import com.myschool.constants.endpoints.ConsoleApi;
import com.myschool.manageops.auth.SessionService;
import com.myschool.manageops.service.StaffService;
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
public class StaffAuth {
    private final StaffService staffService;
    private final SessionService sessionService;

    @PostMapping(ConsoleApi.STAFF_LOGIN)
    public ResponseEntity<AuthTokenResponse> staffLogin(@RequestBody LoginRequest request) {
        UUID staffId = staffService.getStaffId(request);
        AuthTokenResponse authTokenResponse = sessionService.getAuthToken(staffId);
        HttpHeaders headers = new HttpHeaders();
        headers.add(Defaults.USER_TOKEN, authTokenResponse.getAuthToken());

        return ResponseEntity.ok()
                .headers(headers)
                .body(authTokenResponse);
    }

    @PostMapping(ConsoleApi.STAFF_LOGOUT)
    public Boolean staffLogout(ServerHttpRequest request) {
        return sessionService.logOutUser(request);
    }
}
