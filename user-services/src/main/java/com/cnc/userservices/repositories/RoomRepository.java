package com.cnc.userservices.repositories;

public interface RoomRepository {

    boolean add(Long userId, Long roomId);

    boolean delete(Long userId, Long roomId);
}
