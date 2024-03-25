package com.cnc.userservices.messaging;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RedisMessageListener  implements MessageListener {

    public static final Logger LOGGER = LoggerFactory.getLogger(RedisMessageListener.class);
    
	@Override
	public void onMessage(Message message, @Nullable byte[] pattern) {
        String channel = new String(message.getChannel());
        String body = new String(message.getBody());
        LOGGER.info("Received message: " + body + " from channel: " + channel);
	}

}
