package com.cnc.chatservices.services;

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
    boolean save(Long userId, Long groupdId, String messagge);

}
