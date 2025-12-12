package com.example.accchat3.domain.chat.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetChatRoomResponseDto {
    private Integer id;
    private String name;
    private MessageDto lastMessage;
    private UserInfoDto sender;
}
