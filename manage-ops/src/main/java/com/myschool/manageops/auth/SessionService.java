package com.myschool.manageops.auth;

import com.myschool.commons.dto.AuthTokenResponse;
import com.myschool.commons.dto.LoginRequest;
import com.myschool.manageops.client.RedisClient;
import com.myschool.manageops.domain.entities.User;
import com.myschool.manageops.domain.entities.UserCredentials;
import com.myschool.manageops.domain.entities.UserSession;
import com.myschool.manageops.domain.repository.UserCredentialsRepo;
import com.myschool.manageops.domain.repository.UserRepo;
import com.myschool.manageops.domain.repository.UserSessionRepo;
import com.myschool.manageops.utils.PasswordUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.myschool.constants.Defaults.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class SessionService {
    private final UserRepo userRepo;
    private final UserCredentialsRepo userCredentialsRepo;
    private final UserSessionRepo sessionRepo;
    private final SessionManager sessionManager;
    private final RedisClient redisClient;

    public AuthTokenResponse getAuthToken(LoginRequest loginRequest) {
        try {
            List<User> users = userRepo.getUserByContact(loginRequest.getEmailId(), null);
            if (CollectionUtils.isEmpty(users)) {
                return null;
            }

            User selectedUser = users.get(0);
            UserCredentials credentials = userCredentialsRepo.findById(selectedUser.getId()).orElse(null);
            if (credentials == null || !PasswordUtil.matchPassword(loginRequest.getPassword(), credentials.getPassword())) {
                return null;
            }
            List<UserSession> activeSessions = sessionRepo.getActiveSessionForUser(selectedUser.getId());
            if (activeSessions.size() >= MAX_SESSION_ALLOWED) {
                return null;
            }

            AuthTokenResponse authTokenResponse = sessionManager.createAuthTokenForUser(selectedUser);
            redisClient.setValue(authTokenResponse.getAuthToken(), String.valueOf(selectedUser.getId()));

            return sessionManager.createAuthTokenForUser(selectedUser);
        } catch (Exception e) {
            return null;
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
