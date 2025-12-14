package com.example.accchat3.domain.auth.entity;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.time.LocalDateTime;

@DynamoDbBean
public class User {

    private Integer userId;      // PK
    private String userName;
    private String email;
    private String password;
    private Integer tokenId;
    private LocalDateTime createdAt;

    // 파티션 키 설정
    // DynamoDbAttribute는 DynamoDB 속성명과 매핑
    @DynamoDbPartitionKey
    @DynamoDbAttribute("userId")
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) { this.userId = userId; }

    @DynamoDbAttribute("userName")
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @DynamoDbAttribute("email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @DynamoDbAttribute("password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @DynamoDbAttribute("tokenId")
    public Integer getTokenId() {
        return tokenId;
    }
    public void setTokenId(Integer tokenId) { this.tokenId = tokenId;}

    @DynamoDbAttribute("createdAt")
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}