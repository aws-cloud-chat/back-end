package com.example.accchat3.domain.chat.entity;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.util.Date;

@DynamoDbBean
public class ChatRoom {
    private Integer chatRoomId;
    private Integer createdAt;

    private String chatRoomName;

    private String lastMessageId;
    private String lastMessageContent;
    private Integer seq;
    private Date updatedAt;

    private Integer senderId;
    private String senderName;
    private Integer receiverId;
    private String receiverName;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("chatRoomId")
    public Integer getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(Integer chatRoomId){
        this.chatRoomId = chatRoomId;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("createdAt")
    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    @DynamoDbAttribute("chatRoomName")
    public String getChatRoomName() {
        return chatRoomName;
    }

    public void setChatRoomName(String chatRoomName) {
        this.chatRoomName = chatRoomName;
    }

    @DynamoDbAttribute("lastMessageId")
    public String getLastMessageId() {
        return lastMessageId;
    }

    public void setLastMessageId(String lastMessageId) {
        this.lastMessageId = lastMessageId;
    }

    @DynamoDbAttribute("lastMessageContent")
    public String getLastMessageContent() {
        return lastMessageContent;
    }

    public void setLastMessageContent(String lastMessageContent) {
        this.lastMessageContent = lastMessageContent;
    }

    @DynamoDbAttribute("seq")
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @DynamoDbAttribute("updatedAt")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @DynamoDbAttribute("senderId")
    public Integer getSenderId() {
        return senderId;
    }
    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    @DynamoDbAttribute("senderName")
    public String getSenderName() {
        return senderName;
    }
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    @DynamoDbAttribute("receiverId")
    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    @DynamoDbAttribute("receiverName")
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }


}



