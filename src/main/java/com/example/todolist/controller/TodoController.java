
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


    // 회원 별 조회
    ///@GetMapping("/todo/{member_id}")
    ///public Long searchByMember(@PathVariable Long member_id) {
    ///    return todoService.searchByMember();
    ///}


    @PatchMapping("/todo/{id}")   // 수정
    public Long update(@PathVariable Long id, @RequestBody TodoUpdateRequestDto requestDto) {
        return todoService.update(id, requestDto);
    }

    @DeleteMapping("/todo/{id}")  // 삭제
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }

    ///@PatchMapping("/todo/{id}")     // check 수정 .. api 가 똑같아지는데...?
    ///public Long flagupdate(@PathVariable Long id, @RequestBody TodoFlagupdateRequestDto flagrequestDto) {
    ///   return todoService.flagupdate(id, flagrequestDto);
    ///}
}


