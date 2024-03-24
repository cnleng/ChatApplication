package com.cnc.userservices.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("ChatRoomRepository")
@Transactional
public class ChatRoomRepository implements RoomRepository {

    private static final String DELETE_USER_ROOM = "delete from user_rooms where user_id = ? AND room_id = ?";
    private static final String INSERT_USER_ROOM = "insert into user_rooms (user_id, room_id) VALUES (?, ?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean add(Long userId, Long roomId) {
        return jdbcTemplate.update(INSERT_USER_ROOM, userId, roomId) > 0;
    }

    @Override
    public boolean delete(Long userId, Long roomId) {
        return jdbcTemplate.update(DELETE_USER_ROOM, userId, roomId) > 0;
    }

}
