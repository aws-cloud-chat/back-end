package com.example.accchat3.domain.chat.entity;


import lombok.Getter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@Getter
@Setter
@DynamoDbBean
public class ChatRoomItem {

    private Long pk; // chatRoomId
    private String sk;

    private String lastMessageId;           // MSG#3
    private String lastMessageContent;      // "ㅇㅇ 잘듣"
    private Long lastMessageSenderId;
    private String lastMessageSenderName;
    private Long lastMessageSeq;
    private Long messageUpdatedAt;



    @DynamoDbPartitionKey
    public Long getPk() { return pk; }

    @DynamoDbSortKey
    public String getSk() { return sk; }

}
