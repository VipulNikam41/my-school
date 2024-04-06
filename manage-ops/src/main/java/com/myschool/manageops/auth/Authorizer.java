package com.myschool.manageops.auth;

import com.myschool.commons.dto.StatefulRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Authorizer {
    private final SessionService sessionService;

    public boolean setLoggedInUser(StatefulRequest request, ServerHttpRequest headers) {
        try {
            if (request.getCurrentLoggedInUser() != null) {
                request.setCurrentLoggedInUser(null);
                return false;
            }
            request.setCurrentLoggedInUser(
                    sessionService.authenticateSession(
                            headers.getHeaders().getFirst(HttpHeaders.AUTHORIZATION)
                    )
            );
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
