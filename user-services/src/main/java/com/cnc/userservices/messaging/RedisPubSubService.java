package com.cnc.userservices.messaging;

import org.springframework.stereotype.Service;

import com.cnc.userservices.exceptions.BrokerServiceException;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * 
 */
// @Service
public class RedisPubSubService implements BrokerService {

    private Jedis jedis;

    @Override
    public boolean subscribe(String channel) throws BrokerServiceException {

        try {
            this.jedis.subscribe(new JedisPubSub() {
                @Override
                public void onMessage(String channel, String message) {
                    super.onMessage(channel, message);
                }
            }, channel);
            return true;
        } catch (Exception e) {
            throw new BrokerServiceException(e.getMessage());
        }

    }

    @Override
    public boolean publish(String channel, String message) throws BrokerServiceException {
        try {
            this.jedis.publish(channel, message);
            return true;
        } catch (Exception e) {
            throw new BrokerServiceException(e.getMessage());
        }
    }

	@Override
	public boolean unsubscribe(String topic) throws BrokerServiceException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'unsuscribe'");
	}

}
