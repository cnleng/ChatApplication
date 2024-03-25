package com.cnc.chatservices.services;

import java.util.List;

import com.cnc.chatservices.exceptions.MessageServiceException;
import com.cnc.chatservices.model.ChatMessage;

/**
 * 
 */
public interface MessageService {

    /**
     * 
     * @param userId
     * @param groupdId
     * @return
     */
    boolean save(Long userId, Long groupdId, String message) throws MessageServiceException;

	List<ChatMessage> getMessagesByRoom(Long roomId) throws MessageServiceException;

}
