package com.example.api.task;

import com.example.api.service.RedisService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * This class sets a scheduler to run each second to update api value in redis
 */
@EnableScheduling
@Component
public class UpdateRedisTask {

    private final RedisService redisService;

    public UpdateRedisTask(RedisService redisService) {
        this.redisService = redisService;
    }

    @Scheduled(fixedRate = 1000)
    public void setRedisTime() {
        redisService.setTimeValue();
    }
}
