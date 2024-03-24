package com.cnc.userservices.services;

/**
 * 
 */
public interface BrokerService {
    boolean subscribe(String topic) throws GroupServiceException;
    boolean publish(String message) throws GroupServiceException;
}
