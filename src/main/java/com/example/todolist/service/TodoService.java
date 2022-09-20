package com.example.todolist.service;


import com.example.todolist.Dto.TodoCreateRequestDto;
import com.example.todolist.domain.Member;
import com.example.todolist.domain.Todo;
import com.example.todolist.repository.MemberRepository;
import com.example.todolist.repository.TodoRepository;
import lombok.Builder;
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
        Todo todo = Todo.builder()
                .member(member.orElseThrow())
                .list(requestDto.getList())
                .check(false).build();
        return todoRepository.save(todo).getId();
    }
    // 1. 사용자입장에서 기능  2. 스토리를 기반으로 서버에서 어떤 일을 해줘야하는지 ,api, 3. api 목록 / 어떤 데이터 받아야하고 어떤 데이터를 돌려주는지
    //



}
