package com.cnc.userservices.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnc.userservices.services.GroupService;


@RestController
@RequestMapping("/users")
public class UserController {

    public final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    @Qualifier("ChatRoomService")
    private GroupService roomService;

    @PostMapping("/subscribe")
    public ResponseEntity<ApiResponse> joinChatRoom(@RequestBody ChatRoomRequest request) {
        Long userId = request.getUserId();
        Long roomId = request.getRoomId();
        try {
            boolean success = roomService.subscribe(userId, roomId);
            ApiResponse response = new ChatRoomResponse(success);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("An error occurred while subscribing a chat room", e);
            ApiResponse response = new ChatRoomResponse( "An error occurred while subscribing a chat room", e.getMessage(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/unsubscribe")
    public ResponseEntity<ApiResponse> leaveChatRoom(@RequestBody ChatRoomRequest request) {
        Long userId = request.getUserId();
        Long roomId = request.getRoomId();
        try {
            boolean success = roomService.unsuscribe(userId, roomId);
            ApiResponse response = new ChatRoomResponse(success);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("An error occurred while unsuscribing a chat room", e);
            ApiResponse response = new ChatRoomResponse( "An error occurred while unsuscribing a chat room", e.getMessage(), false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
