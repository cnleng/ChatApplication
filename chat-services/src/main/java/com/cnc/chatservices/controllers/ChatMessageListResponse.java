package com.cnc.chatservices.controllers;

import java.util.ArrayList;
import java.util.List;

class ChatMessageListResponse extends ApiResponse {

    private int count;
    private List<ChatMessageResponse> responses = new ArrayList<>();

    public ChatMessageListResponse(String message, String error) {
        super(message, error);
    }

    public ChatMessageListResponse(List<ChatMessageResponse> responses) {
        this.count = responses.size();
        this.responses = responses;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setResponses(List<ChatMessageResponse> responses) {
        this.responses = responses;
    }

    public int getCount() {
        return count;
    }
    
    public List<ChatMessageResponse> getResponses() {
        return responses;
    }

}
