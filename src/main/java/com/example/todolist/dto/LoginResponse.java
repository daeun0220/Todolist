package com.example.todolist.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class LoginResponse {

    private String accessToken;

    @Builder
    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
