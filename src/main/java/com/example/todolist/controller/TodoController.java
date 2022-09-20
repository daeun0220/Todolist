
package com.example.todolist.controller;


import com.example.todolist.Dto.TodoCreateRequestDto;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todo")
    public Long create(@RequestBody TodoCreateRequestDto requestDto){
        return todoService.create(requestDto);
    }



}


