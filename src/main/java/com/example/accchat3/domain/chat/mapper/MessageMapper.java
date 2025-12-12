package com.example.accchat3.domain.chat.mapper;


import com.example.accchat3.domain.chat.dto.MessageDto;
import com.example.accchat3.domain.chat.entity.Message;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class MessageMapper {

    public MessageDto toDto(Message entity){
        return MessageDto.builder()
                .id(entity.getMessagedId())
                .createdAt( LocalDateTime.ofInstant(
                        Instant.ofEpochMilli(entity.getCreatedAt()),
                        ZoneId.of("Asia/Seoul")
                ))
                .content(entity.getMessageContent())
                .build();
    }
}
