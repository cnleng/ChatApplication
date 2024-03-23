package com.cnc.userservices.services;

/**
 * 
 */
public interface RoomService {

    boolean join(Long userId, Long roomId) throws RoomServiceException;

    boolean leave(Long userId, Long roomId) throws RoomServiceException;

}
