
package com.example.todolist.controller;


import com.example.todolist.dto.*;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NamedStoredProcedureQueries;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todo")  // 등록
    public Long create(@RequestBody TodoCreateRequestDto requestDto) {

        return todoService.create(requestDto);
    }

    @GetMapping("/todo/{id}")     // 개별조회
    public TodoResponseDto searchById(@PathVariable Long id) {
        return todoService.searchById(id);
    }


    @GetMapping("/todo")   // 전체조회
    public List<TodoListResponseDto> searchAllDesc() {
        return todoService.searchAllDesc();
    }


    /**
     *  사용자로부터 받아야하는데이터 : member_id
     *  사용자에게 돌려줘야하는데이터 : [{ .. }, { .. }]
     */
    // 회원 별 조회
    @GetMapping("/todo/member/{member_id}")   //이름 membercontroller에 담자
    public List<TodoMemberResponseDto> searchByMember(@PathVariable("member_id") Long memberId) {
       return todoService.searchByMember(memberId);
    }


    @PatchMapping("/todo/{id}")   // 수정
    public Long update(@PathVariable Long id, @RequestBody TodoUpdateRequestDto requestDto) {
        return todoService.update(id, requestDto);
    }

    @DeleteMapping("/todo/{id}")  // 삭제
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }

    @PatchMapping("/todo/flag/{id}")     // check 수정 .. api 다르게 만들기
    public Long flagUpdate(@PathVariable Long id, @RequestBody TodoFlagUpdateRequestDto flagRequestDto) {
        return todoService.flagUpdate(id, flagRequestDto);
    }


}


