package com.example.accchat3.domain.chat.mapper;

import com.example.accchat3.domain.chat.dto.GetChatRoomResponseDto;
import com.example.accchat3.domain.chat.dto.MessageDto;
import com.example.accchat3.domain.chat.dto.UserInfoDto;
import com.example.accchat3.domain.chat.entity.ChatRoom;
import com.example.accchat3.domain.chat.util.TimeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.ZoneId;



@Component
@RequiredArgsConstructor
public class ChatRoomMapper {
    private static final ZoneId KST = ZoneId.of("Asia/Seoul");

    private MessageMapper messageMapper=new MessageMapper();

    public GetChatRoomResponseDto toDto(ChatRoom room) {
        return GetChatRoomResponseDto.builder()
                .id(room.getChatRoomId())
                .name(room.getChatRoomName())
                .lastMessage(messageMapper.toLastMessageDto(room))
                .build();
    }

}
