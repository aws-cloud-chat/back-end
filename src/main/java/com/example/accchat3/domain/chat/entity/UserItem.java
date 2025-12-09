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
public class UserItem {

    private Long pk; //userId

    private String username;
    private String email;
    private String passwordHash;

    private String accessToken;
    private String refreshToken;

    @DynamoDbPartitionKey
    public Long getPk(){return pk;}

}
