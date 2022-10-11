package com.example.todolist.dto;

import com.example.todolist.domain.Todo;
import lombok.Getter;

@Getter
public class TodoListResponseDto {
    private Long id;
    private String member;
    private String contents;
    private boolean flag;

    public TodoListResponseDto(Todo entity){
        this.id = entity.getId();
        this.member = entity.getMember().getNickname();
        this.contents = entity.getContents();
        this.flag = entity.isFlag();

    }
}
