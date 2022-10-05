package com.example.todolist.dto;

import com.example.todolist.domain.Member;

import lombok.Data;

@Data
public class RegisterResponse {

    private Long memberId;
    private String email;
    private String nickname;

    public RegisterResponse(Member member) { // 생성자 AuthService 에서 Member 담아야해서 만들어줘야함
        this.memberId = member.getId();
        this.email = member.getEmail();
        this.nickname = member.getNickname();
    }

}
