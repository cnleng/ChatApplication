package com.cnc.chatservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cnc.chatservices.model.ChatMessage;
import com.cnc.chatservices.repositories.MessageRepository;

@Service("ChatMessageService")
public class ChatMessageService implements MessageService {

    @Autowired
    @Qualifier("ChatMessageRepository")
    private MessageRepository repository;

	@Override
	public boolean save(Long userId, Long groupdId, String content) {
		ChatMessage message = new ChatMessage(userId, groupdId, content);
        return repository.save(message);
	}

}
