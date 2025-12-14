package com.example.accchat3.domain.chat.repository;

import com.example.accchat3.domain.chat.dto.MessageDto;
import com.example.accchat3.domain.chat.entity.ChatRoom;
import com.example.accchat3.domain.chat.entity.Message;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

@Repository
@RequiredArgsConstructor
public class ChatMessageRepository {
    private final DynamoDbEnhancedClient enhancedClient;
    private DynamoDbTable<Message> table;

    @PostConstruct
    public void init(){
        this.table = enhancedClient.table("Message", TableSchema.fromBean(Message.class));
    }

}
