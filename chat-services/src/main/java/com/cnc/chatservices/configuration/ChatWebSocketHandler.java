package com.cnc.chatservices.configuration;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.cnc.chatservices.services.MessageService;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {

    public static final Logger LOGGER = LoggerFactory.getLogger(ChatWebSocketHandler.class);
    private final Set<WebSocketSession> sessions = new HashSet<>();
    @Autowired
    @Qualifier("ChatMessageService")
    private MessageService service;

    @Override
    public void afterConnectionEstablished(@NonNull WebSocketSession session) throws Exception {
        LOGGER.info("User " + session.getId() + " joins the group");
        sessions.add(session);
    }

    @Override
    public void handleTextMessage(@NonNull WebSocketSession session, @NonNull TextMessage message) throws Exception {
        LOGGER.info("Headers");
        Map<String, String> headers = session.getHandshakeHeaders().toSingleValueMap();
        headers.forEach((k, v) -> LOGGER.info((k + ":" + v)));
        service.save(1L, 1L, message.toString());
        for (WebSocketSession s : sessions) {
            s.sendMessage(message);
        }
    }

    @Override
    public void afterConnectionClosed(@NonNull WebSocketSession session, @NonNull CloseStatus status) throws Exception {
        LOGGER.info("User " + session.getId() + " left the group");
        sessions.remove(session);
    }

}
