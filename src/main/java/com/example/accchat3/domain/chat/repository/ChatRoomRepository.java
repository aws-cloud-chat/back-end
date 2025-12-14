package com.example.accchat3.domain.chat.repository;


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

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ChatRoomRepository {
    private final DynamoDbEnhancedClient enhancedClient;
    private DynamoDbTable<ChatRoom> table;

    @PostConstruct
    public void init(){
        this.table = enhancedClient.table("ChatRoom", TableSchema.fromBean(ChatRoom.class));
    }

    public void save(ChatRoom chatRoom){
        table.putItem(chatRoom);
    }

    public Optional<ChatRoom> findById(Integer chatRoomId) {
        var result = table.query(r -> r
                .queryConditional(
                        QueryConditional.keyEqualTo(
                                Key.builder().partitionValue(chatRoomId).build()
                        )
                )
                .scanIndexForward(false) // 최신 먼저 (SK 내림차순)
                .limit(1)
        );

        return result.items().stream().findFirst();
    }

    public void delete(Long chatRoomId) {
        Key key = Key.builder().partitionValue(chatRoomId).build();
        table.deleteItem(key);
    }
}
