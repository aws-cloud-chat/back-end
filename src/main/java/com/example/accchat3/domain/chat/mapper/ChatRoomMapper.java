package com.example.accchat3.domain.chat.mapper;


import com.example.accchat3.domain.auth.entity.User;
import com.example.accchat3.domain.chat.dto.GetChatRoomResponseDto;
import com.example.accchat3.domain.chat.dto.MessageDto;
import com.example.accchat3.domain.chat.dto.UserInfoDto;
import com.example.accchat3.domain.chat.entity.ChatRoom;
import com.example.accchat3.domain.chat.entity.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static io.lettuce.core.KillArgs.Builder.id;

@Component
@RequiredArgsConstructor
public class ChatRoomMapper {
    private static final ZoneId KST = ZoneId.of("Asia/Seoul");


    public GetChatRoomResponseDto toDto(ChatRoom room) {
        return GetChatRoomResponseDto.builder()
                .id(room.getChatRoomId())
                .name(room.getChatRoomName())
                .lastMessage(toLastMessageDto(room))
                .sender(toSenderDto(room))
                .build();
    }



    private MessageDto toLastMessageDto(ChatRoom room) {
        if (room.getLastMessageId() == null) return null;

        return MessageDto.builder()
                .id(room.getLastMessageId())
                .content(room.getLastMessageContent())
                .createdAt(room.getUpdatedAt() == null ? null :
                        LocalDateTime.ofInstant(room.getUpdatedAt().toInstant(), KST))
                .build();
    }

    private UserInfoDto toSenderDto(ChatRoom room) {
        if (room.getSenderId() == null) return null;

        return UserInfoDto.builder()
                .id(room.getSenderId())
                .username(room.getSenderName())
                .build();
    }

}
