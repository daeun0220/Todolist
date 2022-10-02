package com.example.todolist.service;


import com.example.todolist.dto.TodoCreateRequestDto;
import com.example.todolist.domain.Member;
import com.example.todolist.domain.Todo;
import com.example.todolist.dto.TodoUpdateRequestDto;
import com.example.todolist.repository.MemberRepository;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.Collectors;

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




    @Transactional
    public Long update(Long id, TodoUpdateRequestDto requestDto){
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException(("Todo 목록이 존재하지 않습니다.")));
        todo.update(requestDto.getContents(),
                requestDto.getFlag());

        return id;
    }


    @Transactional
    public void delete(Long id){
        Todo todo = todoRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException(("Todo 목록이 존재하지 않습니다. ")));
        todoRepository.delete(todo); // JpaRepository 에서 delete, findById 메소드 지원한다.
    }

}
