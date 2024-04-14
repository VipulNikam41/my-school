package com.myschool.manageops.auth;

import com.myschool.commons.dto.AuthTokenResponse;
import com.myschool.manageops.client.RedisClient;
import com.myschool.manageops.domain.repository.UserSessionRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static com.myschool.constants.Defaults.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class SessionService {
    private final UserSessionRepo sessionRepo;
    private final SessionManager sessionManager;
    private final RedisClient redisClient;

    public AuthTokenResponse getAuthToken(UUID id) {
        AuthTokenResponse authTokenResponse = null;
        try {
            int activeSessions = sessionRepo.countByUserIdAndEndsOnAfter(id, new Date());
            if (activeSessions >= MAX_SESSION_ALLOWED) {
                return null;
            }

            authTokenResponse = sessionManager.createAuthTokenForUser(id);
            redisClient.setValue(authTokenResponse.getAuthToken(), String.valueOf(id));

            return authTokenResponse;
        } catch (Exception e) {
            return authTokenResponse;
        }
    }

    public UUID authenticateSession(String jwtToken) {
        try {
            String token = jwtToken.replace(AUTH_TYPE + " ", "");
            String userId = redisClient.getValue(token);
            if (userId != null) {
                log.info(" :: authenticateSession :: user auth token was present in redis, {}xxx ", jwtToken.substring(0, 10));
                return UUID.fromString(userId);
            }
            return sessionManager.getUserId(token);
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean logOutUser(ServerHttpRequest request) {
        return sessionManager.expireCurrentSession(getToken(request));
    }

    private String getToken(ServerHttpRequest request) {
        return Optional.ofNullable(request)
                .map(ServerHttpRequest::getHeaders)
                .map(h -> h.get(AUTHORIZATION))
                .map(l -> l.get(0))
                .map(s -> s.replace(AUTH_TYPE + " ", ""))
                .orElse(null);
    }
}
