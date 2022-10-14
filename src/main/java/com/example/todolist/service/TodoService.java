package com.example.todolist.service;


import com.example.todolist.dto.*;
import com.example.todolist.domain.Member;
import com.example.todolist.domain.Todo;
import com.example.todolist.repository.MemberRepository;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final MemberRepository memberRepository;

    @Transactional  //등록
    public Long create(TodoCreateRequestDto requestDto) {
        Optional<Member> member = memberRepository.findById(requestDto.getMemberId());
        Todo todo = Todo.builder()  // 객체 생성하는 new() 아닌 builder 방법
                .member(member.orElseThrow()).contents(requestDto.getContents()).flag(false).build();
        return todoRepository.save(todo).getId();
    }

    @Transactional   //개별조회
    public TodoResponseDto searchById(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(()    // optional orElseThrow()
                -> new IllegalArgumentException("해당 Todo 목록이 존재하지 않습니다. "));
        return new TodoResponseDto(todo);   //entity..?
    }

    @Transactional   //전체조회
    public List<TodoListResponseDto> searchAllDesc() {  //질문: findAllDesc 안되는이유
        return todoRepository.findAllByOrderByIdDesc().stream().map(TodoListResponseDto::new).collect(Collectors.toList());
    }

    // 회원 별 조회  (로그인 하고)
    @Transactional
    public List<TodoMemberResponseDto> searchByMember(Long memberId) {        // jpa 에 추가해줘야하나..
        return todoRepository.findByMember(memberId).stream()
                .map(TodoMemberResponseDto::new)
                .collect(Collectors.toList());
    }



    @Transactional    //수정
    public Long update(Long id, TodoUpdateRequestDto requestDto) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(("Todo 목록이 존재하지 않습니다.")));
        todo.update(requestDto); // domain update에 보기 좋게 숨김
        // todoRepository.save() 를 안해도되는 이유 -> Dirty Checking (변경감지) / 명시적으로 해주는 것도 좋다
        return id;
    }


    @Transactional    //삭제
    public void delete(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(("Todo 목록이 존재하지 않습니다. ")));
        todoRepository.delete(todo); // JpaRepository 에서 delete, findById 메소드 지원한다.
    }

    ///@Transactional  // check 수정
    ///public Long flagupdate(Long id, TodoFlagupdateRequestDto flagrequestDto) {
    ///    Todo todo = todoRepository.findById(id)
    ///            .orElseThrow(() -> new
    ///                    IllegalArgumentException(("Todo 목록이 존재하지 않습니다.")));
    ///    todo.flagupdate(flagrequestDto.isFlag());

    ///   return id;
    ///}

}
