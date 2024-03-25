package com.cnc.chatservices.controllers;

public class SendResponse extends ApiResponse {

    private boolean success;

    public SendResponse(boolean success) {
        this.success = success;
    }

    public SendResponse(String message, String error, boolean success) {
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
