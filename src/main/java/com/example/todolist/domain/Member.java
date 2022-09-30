package com.example.todolist.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter   // Setter 안하는 이유....?  ORM 기술... 영속성... Entity 가 일관된 상태를 유지해야하기 때문
@NoArgsConstructor(access = AccessLevel.PROTECTED)// 기본 생성자 생성. @Entity 에 포함됨
@Table(name = "Member")

public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String password;

    private String nickname;

    // TODO: 생성자랑 builder 차이....
    @Builder
    public Member(String email, String password, String nickname){
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}
