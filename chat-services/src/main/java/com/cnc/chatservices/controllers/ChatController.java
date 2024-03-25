package com.cnc.chatservices.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnc.chatservices.messaging.RedisService;
import com.cnc.chatservices.model.ChatMessage;
import com.cnc.chatservices.services.MessageService;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    @Qualifier("ChatMessageService")
    private MessageService messageService;

    @Autowired
    private RedisService redisService;

    @PostMapping("/send")
    public ResponseEntity<ApiResponse> send(@RequestBody SendRequest request) {
        // TODO: Add authentication and authorization verification for current user
        try {
            Long userId = request.getUserId();
            Long roomId = request.getRoomId();
            String message = request.getMessage();
            // Save the message to db
            boolean success = messageService.save(userId, roomId, message);
            if (success) {
               redisService.publish(String.valueOf(roomId), message);
            }
            ApiResponse response = new SendResponse(success);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("An error occurred while subscribing a chat room", e);
            ApiResponse response = new SendResponse( "An error occurred while sending a message to a chat room", e.getMessage(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/messages/{roomId}")
    public ResponseEntity<ApiResponse> getMessages(@PathVariable Long roomId) {
         // TODO: Add authentication and authorization verification for current user
         try {
            // Save the message to db
            List<ChatMessage> messages = messageService.getMessagesByRoom(roomId);
                        List<ChatMessageResponse> responses = messages.stream().
                                           map( m -> new ChatMessageResponse(m.getId(), m.getSenderId(), m.getReceiverId(), m.getContent(),m.getTimestamp())).
                                           collect(Collectors.toList());
            ApiResponse response = new ChatMessageListResponse(responses);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("An error occurred while getting messages from chat room " + roomId, e);
            ApiResponse response = new SendResponse( "An error occurred while getting messages from chat room " + roomId, e.getMessage(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
