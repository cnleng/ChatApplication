package com.cnc.chatservices.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cnc.chatservices.exceptions.MessageServiceException;
import com.cnc.chatservices.model.ChatMessage;
import com.cnc.chatservices.repositories.MessageRepository;

@Service("ChatMessageService")
public class ChatMessageService implements MessageService {

	public static final Logger LOGGER = LoggerFactory.getLogger(ChatMessageService.class);

	@Autowired
	@Qualifier("ChatMessageRepository")
	private MessageRepository repository;

	@Override
	public boolean save(Long userId, Long roomId, String content) throws MessageServiceException {
		try {
			ChatMessage message = new ChatMessage(userId, roomId, content);
			return repository.save(message);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new MessageServiceException(e.getMessage());
		}
	}

	@Override
	public List<ChatMessage> getMessagesByRoom(Long roomId) throws MessageServiceException {
		try {
			List<ChatMessage> messages = repository.getMessagesByRoom(roomId);
			return messages;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new MessageServiceException(e.getMessage());
		}
	}

}
