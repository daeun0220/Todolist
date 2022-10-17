package com.example.todolist.dto;

import com.example.todolist.domain.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    private String nickname;
    private String email;

    public MemberResponseDto(Member entity) {
        this.nickname = entity.getNickname();
        this.email = entity.getEmail();
    }


}
