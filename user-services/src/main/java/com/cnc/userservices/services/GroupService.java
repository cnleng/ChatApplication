package com.cnc.userservices.services;

/**
 * 
 */
public interface GroupService {

    boolean subscribe(Long userId, Long roomId) throws GroupServiceException;

    boolean unsuscribe(Long userId, Long roomId) throws GroupServiceException;

}
