package com.example.todolist.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter   // Setter 안하는 이유....?  ORM 기술... 영속성... Entity 가 일관된 상태를 유지해야하기 때문
@NoArgsConstructor(access = AccessLevel.PROTECTED)// 기본 생성자 생성. @Entity 에 포함됨
@Table(name = "Member")
@AllArgsConstructor // 빌더가 필요한 생성자 만들어줌
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", unique = true, nullable = false)
    private Long id;
    @Column(length = 15, nullable = false)
    private String name;
    @Column(length = 100, nullable = false)
    private String password;

    // 생성자랑 builder 차이....
    @Builder
    public Member(String name, String password){
        this.name = name;
        this.password = password;
    }
}
