package com.example.todolist.controller;

import com.example.todolist.dto.LoginResponse;
import com.example.todolist.dto.LoginRequest;
import com.example.todolist.dto.RegisterRequest;
import com.example.todolist.dto.RegisterResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.todolist.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    //DI 생성자 주입
    private final AuthService authService;  // 생성자 주입 대신 해주는 룸복이 @RequiredArgsConstructor 이다

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @RequestBody RegisterRequest req
    ) {
        RegisterResponse res = authService.register(req);
        return ResponseEntity.ok(res);   // 호출하는 authService에 di 주입해줘야함

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest req) {
        LoginResponse res = authService.login(req);
        return ResponseEntity.ok(res);
    }



}
