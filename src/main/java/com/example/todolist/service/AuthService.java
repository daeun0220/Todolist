package com.example.todolist.service;

import com.example.todolist.domain.Member;
import com.example.todolist.dto.LoginRequest;
import com.example.todolist.dto.LoginResponse;
import com.example.todolist.dto.RegisterRequest;
import com.example.todolist.dto.RegisterResponse;
import com.example.todolist.repository.MemberRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service  // Service에 비지니스 로직 들어간다. service 와 data 간 이어주는거 : repository / service 와 사용자 간 이어주는거: controller
public class AuthService {

    private final static String SECRET_KEY = "daeun0220";

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
    public LoginResponse login(LoginRequest req) {
        Member member = memberRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 이메일입니다."));

        if (!member.validPassword(req.getPassword())) {
            throw new IllegalArgumentException("잘못된 패스워드입니다.");
        }
        // if (!member.getPassword().equals(req.getPassword())) {
        //     throw new IllegalArgumentException("잘못된 패스워드입니다.");
        // }

        // 여기 왔다는 것은 로그인 성공했다.
        // accessToken 넣을 데이터 : 서명, member_id, 만료시간
        long memberId = member.getId();
        long expireTime = System.currentTimeMillis() + (60 * 60 * 1000);

        String accessToken = Jwts.builder()
                .setIssuer(String.valueOf(memberId))
                .setExpiration(new Date(expireTime))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        return LoginResponse.builder()
                .accessToken(accessToken)
                .build();
    }

    public boolean validAccessToken(String parsedAccessToken) throws RuntimeException {
        Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(parsedAccessToken);
        return !claims.getBody().getExpiration().before(new Date());
    }

}
