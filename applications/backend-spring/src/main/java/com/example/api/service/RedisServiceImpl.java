package com.example.api.service;

import com.example.api.constants.RedisKeys;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class RedisServiceImpl implements RedisService {

    private final RedisTemplate<String, String> redisTemplate;
    final static private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public RedisServiceImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public int getRequestsCount() {
        String intString = redisTemplate.opsForValue().get(RedisKeys.NUMBER_OF_REQUESTS.name());
        if (intString == null)
            intString = "0";
        return Integer.parseInt(intString);
    }

    @Override
    public String getTimeValue() {
        this.updateRequestsCount();
        return redisTemplate.opsForValue().get(RedisKeys.TIME_NOW.name());
    }

    @Override
    @Transactional
    public void updateRequestsCount() {
        int currentCount = getRequestsCount();
        currentCount++;
        redisTemplate.opsForValue().set(RedisKeys.NUMBER_OF_REQUESTS.name(), String.valueOf(currentCount));
    }

    @Override
    @Transactional
    public void setTimeValue() {
        redisTemplate.opsForValue().set(RedisKeys.TIME_NOW.name(), (LocalDateTime.now().format(formatter)));
    }
}
