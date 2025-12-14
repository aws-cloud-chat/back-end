package com.example.accchat3.domain.user.converter;

import com.example.accchat3.domain.auth.entity.User;
import com.example.accchat3.domain.user.dto.CreateUserDTO;
import com.example.accchat3.domain.user.dto.UserDTO;

import java.time.LocalDateTime;

public class UserConverter {

    // DTO → Entity
    public static User toUser(CreateUserDTO dto, Integer userId, String encodedPassword) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(encodedPassword);
        user.setTokenId(null);             // 로그인 전. 최초 가입 시 tokenId 없음
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }

    // Entity → DTO
    public static UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getUserId().longValue())
                .username(user.getUserName())
                .build();
    }
}
