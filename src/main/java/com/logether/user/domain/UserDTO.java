package com.logether.user.domain;

import lombok.Data;

@Data
public class UserDTO {
    private String userId;
    private Level levelCode;
    private String userPw;
    private String userName;
}
