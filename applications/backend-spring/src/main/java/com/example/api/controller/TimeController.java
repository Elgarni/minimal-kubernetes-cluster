package com.example.api.controller;

import com.example.api.controller.dto.RequestCountDto;
import com.example.api.controller.dto.ValueDto;
import com.example.api.service.RedisService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    private final RedisService redisService;

    public TimeController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping(value = "/now", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ValueDto now(){
        return new ValueDto(redisService.getTimeValue());
    }

    @GetMapping(value = "/requestsCount", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RequestCountDto getRequestsCount(){
        return new RequestCountDto(redisService.getRequestsCount());
    }
}
