package com.cnc.chatservices.controllers;

import java.time.LocalDateTime;

class ChatMessageResponse extends ApiResponse {
    
    private Long id;
    private Long senderId;
    private Long receiverId;
    private String content;
    private LocalDateTime timestamp;

	public ChatMessageResponse(Long id, Long senderId, Long receiverId, String content, LocalDateTime timestamp) {
		this.id = id;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.content = content;
		this.timestamp = timestamp;
	}
	public ChatMessageResponse(String message, Long id, Long senderId, Long receiverId, String content,
			LocalDateTime timestamp) {
		super(message);
		this.id = id;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.content = content;
		this.timestamp = timestamp;
	}
	public ChatMessageResponse(String message, String error, Long id, Long senderId, Long receiverId, String content,
			LocalDateTime timestamp) {
		super(message, error);
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
	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}
	public Long getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

    
    

}
