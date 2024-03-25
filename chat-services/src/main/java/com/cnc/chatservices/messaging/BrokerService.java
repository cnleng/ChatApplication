package com.cnc.chatservices.messaging;

import com.cnc.chatservices.exceptions.*;

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
    boolean unsuscribe(String topic) throws BrokerServiceException;

    /**
     * 
     * @param topic
     * @return
     * @throws BrokerServiceException
     */
    boolean subscribe(String topic) throws BrokerServiceException;

    /**
     * 
     * @param topic
     * @param message
     * @return
     * @throws BrokerServiceException
     */
    boolean publish(String topic, String message) throws BrokerServiceException;
}
