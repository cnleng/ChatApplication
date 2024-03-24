package com.cnc.userservices.services;

import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * 
 */
@Service
public class RedisPubSubService implements BrokerService {

    private Jedis jedis;

    @Override
    public boolean subscribe(String channel) throws GroupServiceException {

        try {
            this.jedis.subscribe(new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {
                    super.onMessage(channel, message);
                }
            }, channel);
            return true;
        } catch (Exception e) {
            throw new GroupServiceException(e.getMessage());
        }

    }

    @Override
    public boolean publish(String message) throws GroupServiceException {
        try {
            this.jedis.publish(message, message);
            return true;
        } catch (Exception e) {
            throw new GroupServiceException(e.getMessage());
        }
    }

}
