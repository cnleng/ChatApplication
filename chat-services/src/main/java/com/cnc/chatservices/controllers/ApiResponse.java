package com.cnc.chatservices.controllers;

import java.io.Serializable;

abstract class ApiResponse implements Serializable {
    private String message;
    private String error;

    ApiResponse() {
    }

    ApiResponse(String message) {
        this.message = message;
    }

    ApiResponse(String message, String error) {
        this(message);
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
