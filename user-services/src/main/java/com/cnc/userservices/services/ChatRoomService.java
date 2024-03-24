package com.cnc.userservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cnc.userservices.repositories.RoomRepository;

@Service("ChatRoomService")
public class ChatRoomService implements GroupService {

    @Autowired
    @Qualifier("ChatRoomRepository")
    private RoomRepository repository;

    @Override
    public boolean subscribe(Long userId, Long roomId) throws GroupServiceException {
       // Subscribe to the channel that match the Room ID
        return repository.add(userId, roomId);
        
    }

    @Override
    public boolean unsuscribe(Long userId, Long roomId) throws GroupServiceException {
        // TODO Auto-generated method stub
        return repository.delete(userId, roomId);
    }

}
