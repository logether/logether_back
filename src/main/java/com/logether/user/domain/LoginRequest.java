package com.logether.user.domain;

import lombok.Data;

@Data
public class LoginRequest {
    private String userId;
    private String userPw;
}
