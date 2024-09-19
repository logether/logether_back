package com.logether.user.mapper;

import com.logether.user.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {

    Optional<UserDTO> findByUserId(String userId);
}
