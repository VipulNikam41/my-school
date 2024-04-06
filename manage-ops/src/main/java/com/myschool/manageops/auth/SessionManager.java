package com.myschool.manageops.auth;

import com.myschool.commons.dto.AuthTokenResponse;
import com.myschool.manageops.domain.entities.User;
import com.myschool.manageops.domain.entities.UserSession;
import com.myschool.manageops.domain.repository.UserSessionRepo;
import com.myschool.utils.EncryptionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.myschool.constants.Defaults.*;

@Service
@RequiredArgsConstructor
public class SessionManager {
    private final UserSessionRepo sessionRepo;
    private final JwtUtil jwtUtil;

    public AuthTokenResponse createAuthTokenForUser(User user) {
        UserSession newSession = new UserSession();
        newSession.setUserId(user.getId());
        newSession.setEndsOn(
                Date.from(Instant.now().plus(AUTH_TOKEN_EXPIRY_TIME, ChronoUnit.MILLIS))
        );
        sessionRepo.save(newSession);

        String jwtToken = jwtUtil.getJwtTokenForUser(
                EncryptionUtil.encrypt(
                        user.getId() + ACCESS_TOKEN_SEPARATOR + newSession.getId()
                )
        );

        return AuthTokenResponse.builder()
                .userId(user.getId())
                .authType(AUTH_TYPE)
                .authToken(jwtToken)
                .expiryTime(newSession.getEndsOn().toString())
                .build();
    }

    public UUID getUserId(String encryptedAuthToken) {
        List<String> tokenData = this.getSessionParam(encryptedAuthToken);
        UUID userId = UUID.fromString(tokenData.get(0));
        UUID tokenSessionId = UUID.fromString(tokenData.get(1));

        UserSession userSession = sessionRepo.findByIdAndUserId(tokenSessionId, userId);
        if (userSession == null || userSession.isSessionExpired()) {
            return null;
        }

        return userSession.getUserId();
    }

    public Boolean expireCurrentSession(String encryptedAuthToken) {
        List<String> tokenData = this.getSessionParam(encryptedAuthToken);
        UUID userId = UUID.fromString(tokenData.get(0));
        UUID tokenSessionId = UUID.fromString(tokenData.get(1));

        UserSession userSession = sessionRepo.findByIdAndUserId(tokenSessionId, userId);
        if (userSession == null) {
            return false;
        }
        if (userSession.isSessionExpired()) {
            return true;
        }
        userSession.setEndsOn(new Date());
        sessionRepo.save(userSession);

        return true;
    }

    public List<String> getSessionParam(String encryptedAuthToken) {
        String authToken = EncryptionUtil.decrypt(
                jwtUtil.extractSubject(encryptedAuthToken)
        );
        if (authToken == null) {
            return Collections.emptyList();
        }

        return List.of(authToken.split(ACCESS_TOKEN_SEPARATOR));
    }
}
