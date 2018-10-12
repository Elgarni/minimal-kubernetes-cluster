package com.example.api.controller.dto;

public class RequestCountDto {
    private int count;

    public RequestCountDto(int count) {
        this.count = count;
    }

    public RequestCountDto() {
    }

    public int getCount() {
        return count;
    }
}
