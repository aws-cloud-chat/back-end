package com.example.accchat3.domain.chat.repository;


import com.example.accchat3.domain.chat.entity.UserRoomItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ChatDynamoRepository {

    private final DynamoDbEnhancedClient enhancedClient;


    private DynamoDbTable<UserRoomItem> userRoomTable(){
        return enhancedClient.table("ChatApp", TableSchema.fromBean(UserRoomItem.class));
    }

    public Optional<UserRoomItem> findUserRoom(Long userId, Long chatRoomId){
        String pk="USER#"+userId;
        String sk="ROOM#"+chatRoomId;

        Key key= Key.builder().partitionValue(pk).sortValue(sk).build();
        UserRoomItem item=userRoomTable().getItem(r->r.key(key));
        return Optional.ofNullable(item);
    }


}
