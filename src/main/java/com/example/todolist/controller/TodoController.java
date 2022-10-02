
package com.example.todolist.controller;


import com.example.todolist.dto.TodoCreateRequestDto;
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



    @PatchMapping("/todo/{id}")   // 수정
    public Long update(@PathVariable Long id, @RequestBody TodoUpdateRequestDto requestDto){
        return todoService.update(id, requestDto);
    }

    @DeleteMapping("/todo/{id}")  // 삭제
    public void delete(@PathVariable Long id){
        todoService.delete(id);
    }




}


