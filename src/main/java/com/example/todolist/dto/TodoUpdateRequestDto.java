package com.example.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoUpdateRequestDto {
    private String contents;    // id 추가해야하나...?
    private boolean flag;

}
