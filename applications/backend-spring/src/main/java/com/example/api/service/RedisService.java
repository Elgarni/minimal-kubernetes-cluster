package com.example.api.service;

public interface RedisService {
    /**
     * Get request count from redis server
     */
    int getRequestsCount();

    /**
     * Get the api Value from redis server
     */
    String getTimeValue();

    /**
     * update the requests count in redis server
     */
    void updateRequestsCount();

    /**
     * Update the api value in redis server
     */
    void setTimeValue();
}
