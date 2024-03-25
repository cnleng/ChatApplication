package com.cnc.chatservices.controllers;

public class DeleteResponse extends ApiResponse {

    private boolean success;

    public DeleteResponse(boolean success) {
        this.success = success;
    }

    public DeleteResponse(String message, String error, boolean success) {
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
