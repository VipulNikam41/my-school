package com.myschool.manageops.auth;

import com.myschool.constants.Defaults;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtUtil {
    private static final String SECRET = "your-secret-key";

    public String getJwtTokenForUser(String authToken) {
        return Jwts.builder()
                .setSubject(authToken)
                .setExpiration(new Date(System.currentTimeMillis() + Defaults.AUTH_TOKEN_EXPIRY_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    public String extractSubject(String jwtAccessToken) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(jwtAccessToken)
                .getBody()
                .getSubject();
    }
}

