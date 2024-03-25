package com.cnc.chatservices.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cnc.chatservices.model.ChatMessage;
import com.cnc.chatservices.model.ChatMessageMapper;

@Repository("ChatMessageRepository")
@Transactional
public class ChatMessageRepository implements MessageRepository {

    private static final String DELETE_CHAT_MESSAGE = "update chat_messages set message_type = 'DELETED' where id = ?";
    private static final String INSERT_CHAT_MESSAGE = "insert into chat_messages (sender_id, receiver_id, content, message_type) VALUES (?, ?, ?, ?)";
    private static final String RETRIEVE_USER_CHAT_MESSAGES = "select * from chat_messages where receiver_id = %d order by timestamp";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(ChatMessage message) {
        return jdbcTemplate.update(INSERT_CHAT_MESSAGE, message.getSenderId(), message.getReceiverId(), message.getContent(), message.getMessageType().toString()) > 0;
    }

    @Override
    public boolean delete(Long messageId) {
        return jdbcTemplate.update(DELETE_CHAT_MESSAGE, messageId) > 0;
    }

    @Override
    public List<ChatMessage> getMessagesByRoom(Long receiverId) {
        List<ChatMessage> messages = jdbcTemplate.query(String.format(RETRIEVE_USER_CHAT_MESSAGES, receiverId), new ChatMessageMapper());
        return messages;
    }

}
