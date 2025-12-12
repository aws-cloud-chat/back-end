package com.example.accchat3.domain.chat.mapper;

import com.example.accchat3.domain.chat.dto.UserInfoDto;
import com.example.accchat3.domain.chat.entity.ChatRoom;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserInfoDto toDto(ChatRoom entity){
        return UserInfoDto.builder()
                .id(entity.getSenderId())
                .username(entity.getSenderName())
                .build();
    }
}

