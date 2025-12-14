package com.example.accchat3.domain.chat.service;

import java.util.Optional;

import com.example.accchat3.domain.chat.dto.MessageDto;
import com.example.accchat3.domain.chat.entity.ChatRoom;
import com.example.accchat3.domain.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    @Transactional(readOnly = true)
    public ChatRoom getChatRoomById(Integer chatRoomId){
        return chatRoomRepository.findById(chatRoomId)
                .orElseThrow(()->new RuntimeException("Chat room not found with id: "+chatRoomId));

    }


}
