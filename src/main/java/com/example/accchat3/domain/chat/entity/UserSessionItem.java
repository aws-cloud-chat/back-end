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
public class UserSessionItem {
    private String pk;
    private String sk;

    private Long userId;

    private String accessToken;
    private String refreshToken;
    private Long createdAt;
    private Long expiresAt;

    @DynamoDbPartitionKey
    public String getPk() { return pk; }

    @DynamoDbSortKey
    public String getSk() { return sk; }
}
