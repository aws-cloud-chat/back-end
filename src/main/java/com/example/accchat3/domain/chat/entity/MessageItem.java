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
    private String pk;   // ROOM#R1
    private String sk;   // MSG#1

    private String messageId;     // MSG#1
    private Long seq;             // 정렬용 번호
    private Long senderId;
    private String senderUsername;
    private String content;
    private Long createdAt;       // epochMillis

    @DynamoDbPartitionKey
    public String getPk() { return pk; }

    @DynamoDbSortKey
    public String getSk() { return sk; }

}
