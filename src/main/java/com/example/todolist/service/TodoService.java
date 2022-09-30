package com.example.todolist.service;


import com.example.todolist.dto.TodoCreateRequestDto;
import com.example.todolist.domain.Member;
import com.example.todolist.domain.Todo;
import com.example.todolist.repository.MemberRepository;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final MemberRepository memberRepository;
    @Transactional
    public Long create(TodoCreateRequestDto requestDto){
        Optional<Member> member = memberRepository.findById(requestDto.getMemberId());
        Todo todo = Todo.builder()  // 객체 생성하는 new() 아닌 builder 방법
                .member(member.orElseThrow())
                .contents(requestDto.getContents())
                .flag(false).build();
        return todoRepository.save(todo).getId();
    }

}
