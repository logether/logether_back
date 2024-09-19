package com.logether.jwt.domain;

import lombok.Data;

import java.util.Date;

@Data
public class JwtToken {
    private String grantType;
    private String accessToken;
    private String refreshToken;
    private Date accessTokenExpiresIn;
    private Date refreshTokenExpiresIn;
}
