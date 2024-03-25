package com.cnc.userservices.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;

import com.cnc.userservices.exceptions.BrokerServiceException;

@Service("RedisService")
public class RedisService implements BrokerService {

    public static final Logger LOGGER = LoggerFactory.getLogger(RedisService.class);
    private static final String CHANNEL_PREFIX = "room-";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisMessageListenerContainer redisMessageListenerContainer;

    @Autowired
    private RedisMessageListener listener;

    @Override
    public boolean unsubscribe(String channel) throws BrokerServiceException {
        try {
            redisMessageListenerContainer.removeMessageListener(this.listener, new ChannelTopic(CHANNEL_PREFIX+channel));
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new BrokerServiceException(e.getMessage());
        }
    }

    @Override
    public boolean subscribe(String channel) throws BrokerServiceException {
        try {
            LOGGER.info("Subscribing to channel :" + CHANNEL_PREFIX+channel);
            this.redisMessageListenerContainer.addMessageListener(this.listener, new ChannelTopic(CHANNEL_PREFIX+channel));
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new BrokerServiceException(e.getMessage());
        }
    }

    @Override
    public boolean publish(String channel, String message) throws BrokerServiceException {
        try {
            LOGGER.info("Publishing message to channel :" + message + " " + CHANNEL_PREFIX + channel);
            this.redisTemplate.convertAndSend(CHANNEL_PREFIX+channel, message);
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new BrokerServiceException(e.getMessage());
        }
    }
}
