package com.logether.jwt.service;

import com.logether.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

import com.logether.user.domain.UserDTO;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserDTO userDTO = userMapper.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new CustomUserDetails(userDTO);
    }

}
