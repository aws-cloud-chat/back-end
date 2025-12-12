package com.example.accchat3.domain.chat.controller;


import com.example.accchat3.domain.chat.dto.GetChatRoomResponseDto;
import com.example.accchat3.domain.chat.entity.ChatRoom;
import com.example.accchat3.domain.chat.mapper.ChatRoomMapper;
import com.example.accchat3.domain.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chats")
public class ChatController {
    private final ChatRoomService chatRoomService;
    private final ChatRoomMapper chatRoomMapper;


    @GetMapping("/{chatRoomId}")
    public ResponseEntity<GetChatRoomResponseDto> getChatRoom(@PathVariable Long chatRoomId){
        ChatRoom chatRoom=chatRoomService.getChatRoomById(chatRoomId);
        return ResponseEntity.ok(chatRoomMapper.toDto(chatRoom));
    }


}
