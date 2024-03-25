package com.cnc.chatservices.controllers;

public class SendRequest extends ApiRequest {

    private Long userId;
    private Long roomId;
    private String message;

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoomId() {
        return this.roomId;
    }
    
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

    

}
