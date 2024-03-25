package com.cnc.chatservices.services;

import java.util.List;

import com.cnc.chatservices.exceptions.MessageServiceException;
import com.cnc.chatservices.model.ChatMessage;
import com.cnc.chatservices.utils.Constants.MessageType;

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
    boolean save(Long userId, Long groupdId, String message, MessageType messageType) throws MessageServiceException;

    /**
     * 
     * @param roomId
     * @return
     * @throws MessageServiceException
     */
	List<ChatMessage> getMessagesByRoom(Long roomId) throws MessageServiceException;

    /**
     * 
     * @param id
     * @return
     * @throws MessageServiceException
     */
	boolean deleteMessage(Long id) throws MessageServiceException;

}
