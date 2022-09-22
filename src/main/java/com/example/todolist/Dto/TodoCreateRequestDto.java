package com.example.todolist.Dto;

import com.example.todolist.domain.Member;
import com.example.todolist.domain.Todo;
import lombok.Builder;
import lombok.Data;

@Data
public class TodoCreateRequestDto { //계층간의 데이터를 옮겨줄 때
    private Long memberId;
    private String contents;

}
