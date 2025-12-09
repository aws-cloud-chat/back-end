package com.example.accchat3.domain.chat.service;


import com.example.accchat3.domain.chat.dto.GetChatResponseDto;
import com.example.accchat3.domain.chat.dto.MessageDto;
import com.example.accchat3.domain.chat.dto.UserInfoDto;
import com.example.accchat3.domain.chat.entity.UserRoomItem;
import com.example.accchat3.domain.chat.repository.ChatDynamoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatDynamoRepository chatDynamoRepository;


    public GetChatResponseDto getChatRoomById(Long userId, Long chatRoomId){

         UserRoomItem item = chatDynamoRepository.findUserRoom(userId, chatRoomId)
                .orElseThrow(()->new RuntimeException("Chat room not found with id "+chatRoomId));


         MessageDto lastMessage = new MessageDto(
                 item.getLastMessageId(),
                 item.getLastMessageContent(),
                 item.getMessageUpdatedAt(),
                 item.getLastMessageSeq(),
                 new UserInfoDto(
                         item.getLastMessageSenderUserId(),
                         item.getLastMessageSenderUsername()
                 )
         );
    }


}
