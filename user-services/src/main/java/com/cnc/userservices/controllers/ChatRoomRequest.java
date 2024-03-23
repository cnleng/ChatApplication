package com.cnc.userservices.controllers;

public class ChatRoomRequest extends ApiRequest {

    private Long userId;
    private Long roomId;

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

}
