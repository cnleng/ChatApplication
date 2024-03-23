package com.cnc.userservices.controllers;

public class ChatRoomResponse extends ApiResponse {

    private boolean success;

    public ChatRoomResponse(boolean success) {
        this.success = success;
    }

    public ChatRoomResponse(String message, String error, boolean success) {
        super(message, error);
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
}
