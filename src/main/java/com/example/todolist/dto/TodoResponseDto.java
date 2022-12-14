package com.example.todolist.dto;

import com.example.todolist.domain.Todo;
import lombok.Getter;

@Getter  // 개별 조회시 필요    회원 별 조회할때는...?
public class TodoResponseDto {
    private Long id;
    private String member;
    private String contents;
    private boolean flag;

    public TodoResponseDto(Todo entity){
        this.id = entity.getId();
        this.member = entity.getMember().getNickname();
        this.contents = entity.getContents();
        this.flag = entity.isFlag();   // @Data 에서 getFlag 가 아닌 isFlag 지원해준다.
    }
}
