package com.cnc.userservices.messaging;

import com.cnc.userservices.exceptions.BrokerServiceException;

/**
 * 
 */
public interface BrokerService {

    /**
     * 
     * @param topic
     * @return
     * @throws BrokerServiceExceptionx
     */
    boolean unsubscribe(String topic) throws BrokerServiceException;

    /**
     * 
     * @param topic
     * @return
     * @throws BrokerServiceException
     */
    boolean subscribe(String topic) throws BrokerServiceException;

    /**
     * 
     * @param channel
     * @param message
     * @return
     * @throws BrokerServiceException
     */
    boolean publish(String channel, String message) throws BrokerServiceException;
}
