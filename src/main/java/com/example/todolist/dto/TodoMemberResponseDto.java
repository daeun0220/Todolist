package com.example.todolist.dto;


import lombok.Data;

@Data
public class TodoMemberResponseDto {
    private Long memberId;
    private String nickname;
    private String contents;
    private boolean flag;
}
