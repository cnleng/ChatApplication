package com.cnc.userservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cnc.userservices.repositories.RoomRepository;

@Service("ChatRoomService")
public class ChatRoomService implements RoomService {

    @Autowired
    @Qualifier("ChatRoomRepository")
    private RoomRepository repository;

    @Override
    public boolean join(Long userId, Long roomId) throws RoomServiceException {
        // TODO persist to User Database (Postgres)
        return repository.add(userId, roomId);
        // Subscribe to the channel that match the Room ID
    }

    @Override
    public boolean leave(Long userId, Long roomId) throws RoomServiceException {
        // TODO Auto-generated method stub
        return repository.delete(userId, roomId);
    }

}
