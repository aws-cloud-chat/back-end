package com.example.accchat3.domain.chat.mapper;


import com.example.accchat3.domain.chat.dto.MessageDto;
import com.example.accchat3.domain.chat.dto.UserInfoDto;
import com.example.accchat3.domain.chat.entity.ChatRoom;
import com.example.accchat3.domain.chat.util.TimeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageMapper {

    public MessageDto toLastMessageDto(ChatRoom room) {
        if (room.getLastMessageId() == null) return null;

        UserInfoDto sender = (room.getSenderId() == null) ? null
                : UserInfoDto.builder()
                .id(room.getSenderId())
                .username(room.getSenderName())
                .build();

        return MessageDto.builder()
                .id(room.getLastMessageId())
                .content(room.getLastMessageContent())
                .seq(room.getSeq())
                .sender(sender)
                .createdAt(TimeConverter.kstFromEpochMillis(room.getCreatedAt()))
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
