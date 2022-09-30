package com.example.todolist.controller;

import com.example.todolist.dto.RegisterRequest;
import com.example.todolist.dto.RegisterResponse;
import com.example.todolist.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    //DI 생성자 주입
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<RegisterResponse> register(
            @RequestBody RegisterRequest req
    ) {
        RegisterResponse res = authService.register(req);
        return ResponseEntity.ok(res);   // 호출하는 authService에 di 주입해줘야함

    }

}
