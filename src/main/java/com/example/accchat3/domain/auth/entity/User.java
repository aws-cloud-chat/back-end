package com.example.accchat3.domain.auth.entity;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
public class User {
    private Integer userId;
    private String SK;

    private String userName;
    private String email;
    private String password;
    private Integer tokenId;

    // 파티션 키 설정
    // DynamoDbAttribute는 DynamoDB 속성명과 매핑
    @DynamoDbPartitionKey
    @DynamoDbAttribute("userId")
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("SK")
    public String getSK(){
        return SK;
    }

    public void setSK(String SK){
        this.SK = SK;
    }

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

    public void setTokenId(Integer tokenId) {
        this.tokenId = tokenId;
    }
}