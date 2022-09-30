package com.example.todolist.service;

import com.example.todolist.domain.Member;
import com.example.todolist.dto.RegisterRequest;
import com.example.todolist.dto.RegisterResponse;
import com.example.todolist.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  // Service에 비지니스 로직 들어간다. service 와 data 간 이어주는거 : repository / service 와 사용자 간 이어주는거: controller
public class AuthService {

    // DI 생성자 주입 (필드 주입할 경우 final 사용 못함)
    private final MemberRepository memberRepository;

    @Autowired
    public AuthService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public RegisterResponse register(RegisterRequest req){  // 무슨 형태로 반환..?
        // 1. req를 가지고 Member Entity 객체를 생성한다.
        Member newMember = Member.builder()
                .email(req.getEmail())
                .password(req.getPassword())
                .nickname(req.getNickname())
                .build();
        // 2. Member Entity 를 데이터베이스에 저장한다. 이때 memberRespository 에 di ㄱ
        Member createdMember = memberRepository.save(newMember);
        return new RegisterResponse(createdMember);  // 생성자 함수 new 사용해줘야한다
        // 리턴해야할 것 RegisterResponse 형태 안에 담을 내용은 위에서 만든 createdMember
        // RegisterResponse 가 Member 형태 담을 수 있게 --> 생성자 만들어주러 간다.
    }


}
