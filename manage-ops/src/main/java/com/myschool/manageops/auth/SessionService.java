package com.myschool.manageops.auth;

import com.myschool.commons.dto.AuthTokenResponse;
import com.myschool.commons.dto.LoginRequest;
import com.myschool.manageops.domain.entities.User;
import com.myschool.manageops.domain.entities.UserCredentials;
import com.myschool.manageops.domain.entities.UserSession;
import com.myschool.manageops.domain.repository.UserCredentialsRepo;
import com.myschool.manageops.domain.repository.UserRepo;
import com.myschool.manageops.domain.repository.UserSessionRepo;
import com.myschool.manageops.utils.PasswordUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.myschool.constants.Defaults.*;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final UserRepo userRepo;
    private final UserCredentialsRepo userCredentialsRepo;
    private final UserSessionRepo sessionRepo;
    private final SessionManager sessionManager;

    public AuthTokenResponse getAuthToken(LoginRequest loginRequest) {
        try {
            List<User> users = userRepo.getUserByContact(loginRequest.getEmailId(), loginRequest.getEmailId());
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

            return sessionManager.createAuthTokenForUser(selectedUser);
        } catch (Exception e) {
            return null;
        }
    }

    public UUID authenticateSession(String jwtToken) {
        String token = jwtToken.replace(AUTH_TYPE + " ", "");

        return sessionManager.getUserId(token);
    }

    public Boolean logOutUser(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION)
                .replace(AUTH_TYPE + " ", "");

        return sessionManager.expireCurrentSession(token);
    }
}
