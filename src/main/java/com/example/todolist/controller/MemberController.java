package com.example.todolist.controller;

import com.example.todolist.dto.MemberInfoResponseDto;
import com.example.todolist.dto.TodoMemberResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class MemberController {

    // 사용자가 로그인 시 nickname, email 정보를 불러올 수 있다.
    ///@GetMapping("/member/{member_id}")     // 개별조회
    ///public List<MemberInfoResponseDto> searchByMember(@PathVariable("member_id") Long memberId) {
    ///    return todoService.searchByMember(memberId);
    ///}


}
