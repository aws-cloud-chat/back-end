package com.example.accchat3.domain.chat.entity;


import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@Getter
@Setter
@DynamoDbBean
public class UserRoomItem {

    private String pk; // ROOM#1
    private String sk;

    private String lastMessageId;           // MSG#3
    private String lastMessageContent;      // "ㅇㅇ 잘듣"
    private String lastMessageSenderUsername;
    private Long messageUpdatedAt;          // epochMillis 등
    private String receiverUsername;
    private Long receiverUserId;


    @DynamoDbPartitionKey
    public String getPk() { return pk; }

    @DynamoDbSortKey
    public String getSk() { return sk; }

}
