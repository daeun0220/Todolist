package com.example.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  // 필드의 모든 생성자
@NoArgsConstructor   // 기본 생성자
public class LoginRequest {

    private String email;
    private String password;
}
