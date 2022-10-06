
package com.example.todolist.controller;


import com.example.todolist.dto.TodoCreateRequestDto;
import com.example.todolist.dto.TodoResponseDto;
import com.example.todolist.dto.TodoUpdateRequestDto;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todo")  // 등록
    public Long create(@RequestBody TodoCreateRequestDto requestDto){

        return todoService.create(requestDto);
    }

    @GetMapping("/todo/{id}")     // 개별조회
    public TodoResponseDto searchById(@PathVariable Long id){
        return todoService.searchById(id);
    }

    @GetMapping("/todo")   // 전체조회
    public List<TodoListResponseDto> searchAllDesc() {
        return todoService.searchAllDesc();
    }

    @GetMapping("/todo/{nickname}")  //회원 별 조회
    public TodoResponseDto searchByMember(@PathVariable String nickname){
        return todoService.searchByMember(nickname);   // 멤버...

    }




    @PatchMapping("/todo/{id}")   // 수정
    public Long update(@PathVariable Long id, @RequestBody TodoUpdateRequestDto requestDto){
        return todoService.update(id, requestDto);
    }

    @DeleteMapping("/todo/{id}")  // 삭제
    public void delete(@PathVariable Long id){
        todoService.delete(id);
    }




}


