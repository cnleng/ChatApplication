package com.cnc.chatservices.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import com.cnc.chatservices.utils.Constants.MessageType;

public class ChatMessageMapper implements RowMapper<ChatMessage>{

    @Override
    @Nullable
    public ChatMessage mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
        ChatMessage message = new ChatMessage();
		message.setId(rs.getLong("id"));
		message.setSenderId(rs.getLong("sender_id"));
		message.setReceiverId(rs.getLong("receiver_id"));
		message.setContent(rs.getString("content"));
		message.setMessageType(MessageType.valueOf(rs.getString("message_type")));
        Instant instant = Instant.ofEpochMilli(rs.getTimestamp("timestamp").getTime());
        message.setTimestamp(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()));
		return message;
    }

}
