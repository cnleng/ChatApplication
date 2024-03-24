package com.cnc.chatservices.repositories;

import java.util.List;
import com.cnc.chatservices.model.ChatMessage;

/**
 * 
 */
public interface MessageRepository {

    /**
     * 
     * @param messsage
     * @return
     */
    boolean save(ChatMessage messsage);

    /**
     * 
     * @param senderId
     * @param receiverId
     * @return
     */
    List<ChatMessage> retrieve(Long senderId, Long receiverId);

    /**
     * 
     * @param messageId
     * @return
     */
    boolean delete(Long messageId);
}
