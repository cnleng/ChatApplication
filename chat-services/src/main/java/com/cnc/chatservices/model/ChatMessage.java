package com.cnc.chatservices.model;

import java.time.LocalDateTime;

/**
 * 
 */
public class ChatMessage {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private String content;
    private LocalDateTime timestamp;

    public ChatMessage() {
    }

    public ChatMessage(Long senderId, Long receiverId, String content) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
    }

    public ChatMessage(Long id, Long senderId, Long receiverId, String content, LocalDateTime timestamp) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getSenderId() {
        return senderId;
    }
    public void setSenderId(Long userId) {
        this.senderId = userId;
    }
    public Long getReceiverId() {
        return receiverId;
    }
    public void setReceiverId(Long groupId) {
        this.receiverId = groupId;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String message) {
        this.content = message;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    
}
