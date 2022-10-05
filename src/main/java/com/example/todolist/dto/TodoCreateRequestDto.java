package com.example.todolist.dto;

import lombok.Data;

@Data
public class TodoCreateRequestDto { //계층간의 데이터를 옮겨줄 때
    private Long memberId;
    private String contents;   // flag 있어야하지않나..?

}
