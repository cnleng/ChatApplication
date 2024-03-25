package com.cnc.userservices.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cnc.userservices.messaging.BrokerService;
import com.cnc.userservices.repositories.RoomRepository;

@Service("ChatRoomService")
public class ChatRoomService implements GroupService {

    public final Logger LOGGER = LoggerFactory.getLogger(ChatRoomService.class);

    @Autowired
    @Qualifier("ChatRoomRepository")
    private RoomRepository repository;

    @Autowired
    @Qualifier("RedisService")
    private BrokerService broker;

    @Override
    public boolean subscribe(Long userId, Long roomId) throws GroupServiceException {
        try {
            boolean success = this.repository.add(userId, roomId);
            if (success) {
                success = this.broker.subscribe(String.valueOf(roomId));
            }
            return success;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new GroupServiceException(e.getMessage());
        }

    }

    @Override
    public boolean unsuscribe(Long userId, Long roomId) throws GroupServiceException {
        try {
            boolean success = repository.delete(userId, roomId);
            if (success) {
                success = this.broker.unsubscribe(String.valueOf(roomId));
            }
            return success;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new GroupServiceException(e.getMessage());
        }
    }

}
