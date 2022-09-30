package com.example.todolist.dto;

import com.example.todolist.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class RegisterResponse {

    private Long memberId;
    private String email;
    private String nickname;

    //TODO: 생성자 만들어보기
    public RegisterResponse(Member member){

        this.memberId = member.getId();
        this.email = member.getEmail();
        this.nickname = member.getNickname();
    }

}
