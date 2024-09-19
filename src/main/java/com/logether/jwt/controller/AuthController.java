package com.logether.jwt.controller;

import com.logether.jwt.domain.JwtToken;
import com.logether.jwt.service.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jwt")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/refresh")
    public JwtToken refresh(@RequestParam String refreshToken) {
        if (jwtTokenProvider.validateToken(refreshToken)) {
            String username = jwtTokenProvider.getUserIdFromToken(refreshToken);
            String newAccessToken = jwtTokenProvider.createAccessToken(username);

            JwtToken jwtToken = new JwtToken();
            jwtToken.setGrantType("Bearer");
            jwtToken.setAccessToken(newAccessToken);
            jwtToken.setRefreshToken(refreshToken);
            jwtToken.setAccessTokenExpiresIn(new Date(System.currentTimeMillis() + jwtTokenProvider.getAccessTokenExpiration()));
            jwtToken.setRefreshTokenExpiresIn(new Date(System.currentTimeMillis() + jwtTokenProvider.getRefreshTokenExpiration()));

            return jwtToken;
        } else {
            throw new RuntimeException("Invalid refresh token");
        }
    }
}
