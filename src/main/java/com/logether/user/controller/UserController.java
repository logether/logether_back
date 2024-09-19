package com.logether.user.controller;

import com.logether.jwt.domain.JwtToken;
import com.logether.jwt.service.JwtTokenProvider;
import com.logether.user.domain.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public JwtToken login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserId(), loginRequest.getUserPw()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtTokenProvider.createAccessToken(loginRequest.getUserId());
        String refreshToken = jwtTokenProvider.createRefreshToken();

        JwtToken jwtToken = new JwtToken();
        jwtToken.setGrantType("Bearer");
        jwtToken.setAccessToken(accessToken);
        jwtToken.setRefreshToken(refreshToken);
        jwtToken.setAccessTokenExpiresIn(new Date(System.currentTimeMillis() + jwtTokenProvider.getAccessTokenExpiration()));
        jwtToken.setRefreshTokenExpiresIn(new Date(System.currentTimeMillis() + jwtTokenProvider.getRefreshTokenExpiration()));
        System.out.println("Current time: " + new Date());

        return jwtToken;
    }
}
