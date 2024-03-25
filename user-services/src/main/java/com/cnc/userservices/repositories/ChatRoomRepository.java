package com.cnc.userservices.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("ChatRoomRepository")
@Transactional
public class ChatRoomRepository implements RoomRepository {

    private static final String DELETE_USER_ROOM = "delete from subscriptions where user_id = ? AND room_id = ?";
    private static final String INSERT_USER_ROOM = "insert into subscriptions (user_id, room_id) VALUES (?, ?)";
    private static final String GET_SUBSCRIPTION_COUNTS = "select count(*) from subscriptions where user_id = %d AND room_id = %d";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 
     * @param userId
     * @param roomId
     * @return
     */
    private Long countSubscriptions(Long userId, Long roomId) {
        Long count = jdbcTemplate.queryForObject(String.format(GET_SUBSCRIPTION_COUNTS, userId, roomId), Long.class);
        return count;
    }

    @Override
    public boolean add(Long userId, Long roomId) {
        if ( countSubscriptions(userId, roomId) <= 0 ) {
            return jdbcTemplate.update(INSERT_USER_ROOM, userId, roomId) > 0;
        }
        return false;
    }

    @Override
    public boolean delete(Long userId, Long roomId) {
        return jdbcTemplate.update(DELETE_USER_ROOM, userId, roomId) > 0;
    }

}
