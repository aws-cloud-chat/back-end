package com.example.accchat3.domain.chat.entity;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
public class Message {
    private Integer chatRoomId;
    private Integer createdAt;

    private String messagedId;
    private String messageContent;
    private Integer seq;

    private Integer senderId;
    private String senderName;

    private Integer receiverId;
    private String receiverName;


    @DynamoDbPartitionKey
    @DynamoDbAttribute("chatRoomId")
    public Integer getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(Integer chatRoomId) {
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

    @DynamoDbAttribute("messagedId")
    public String getMessagedId() {
        return messagedId;
    }
    public void setMessagedId(String messagedId) {
        this.messagedId = messagedId;
    }

    @DynamoDbAttribute("messageContent")
    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @DynamoDbAttribute("seq")
    public Integer getSeq() {
        return seq;
    }
    public void setSeq(Integer seq) {
        this.seq = seq;
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
