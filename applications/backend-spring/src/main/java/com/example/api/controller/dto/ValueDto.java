package com.example.api.controller.dto;

public class ValueDto {
    private String value ;

    public ValueDto(String value) {
        this.value = value;
    }

    public ValueDto() {
    }

    public String getValue() {
        return value;
    }
}
