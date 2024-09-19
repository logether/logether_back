package com.logether;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String rawPassword = "admin123";  // 원본 비밀번호
        String encodedPassword = passwordEncoder.encode(rawPassword);  // 암호화된 비밀번호
        System.out.println("Encoded Password: " + encodedPassword);
    }
}
