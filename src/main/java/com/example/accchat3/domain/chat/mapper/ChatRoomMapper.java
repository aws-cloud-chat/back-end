package com.example.accchat3.domain.chat.mapper;


import com.example.accchat3.domain.chat.dto.GetChatRoomResponseDto;
import com.example.accchat3.domain.chat.dto.MessageDto;
import com.example.accchat3.domain.chat.entity.ChatRoom;
import com.example.accchat3.domain.chat.entity.Message;
import org.springframework.stereotype.Component;

import static io.lettuce.core.KillArgs.Builder.id;

@Component
public class ChatRoomMapper {

    public GetChatRoomResponseDto toDto(ChatRoom entity){
        return GetChatRoomResponseDto.builder()

    }


    public MessageDto toDto(Message entity){
        return MessageDto.builder()
                .id(entity.getMessagedId())
                .content(entity.getMessageContent())
                .build();
    }
}
