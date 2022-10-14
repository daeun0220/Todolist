package com.example.todolist.dto;


import com.example.todolist.domain.Todo;
import lombok.Data;
import lombok.Getter;

@Getter
public class TodoMemberResponseDto {
    private Long memberId;
    private String nickname;
    private String contents;
    private boolean flag;

    public TodoMemberResponseDto(Todo entity) {
        this.memberId = entity.getMember().getId();
        this.nickname = entity.getMember().getNickname();
        this.contents = entity.getContents();
        this.flag = entity.isFlag();

    }

}
