package com.example.todolist.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class TodoUpdateRequestDto {
    private String contents;    // id 추가해야하나...?
    private Boolean flag;

    @Builder
    public TodoUpdateRequestDto(String contents, Boolean flag){
        this.contents = contents;
        this.flag = flag;
    }

}
