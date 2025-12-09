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
public class MessageItem {
    private Long pk;   // chatRoomId
    private Long sk;   // seq

    private String messageId;     // MSG#1
    private String content;
    private Long createdAt;     // epochMillis

    private Long senderId;
    private String senderName;

    @DynamoDbPartitionKey
    public Long getPk() { return pk; }

    @DynamoDbSortKey
    public Long getSk() { return sk; }

}
