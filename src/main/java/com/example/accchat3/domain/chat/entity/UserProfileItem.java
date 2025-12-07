package com.example.accchat3.domain.chat.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;


@Getter
@Setter
@NoArgsConstructor
@DynamoDbBean
public class UserProfileItem {

    private String pk; //User#1001
    private String sk; //ROOM#R1

    private Long userId;
    private String username;
    private String email;
    private String passwordHash;

    private String lastMessageId;           // MSG#3
    private String lastMessageContent;      // "ㅇㅇ 잘듣"
    private String lastMessageSenderUsername;
    private Long messageUpdatedAt;          // epochMillis 등
    private String receiverUsername;
    private Long receiverUserId;

    @DynamoDbPartitionKey
    public String getPk(){return pk;}

    @DynamoDbSortKey
    public String getSk() { return sk; }

}
