package com.example.todolist.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Todo")
@AllArgsConstructor
public class Todo {
    @Id  // PK 매핑
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Member.class)   // 관계매핑을 위한 어노테이션
    @JoinColumn(name = "member_id", updatable = false)
    private Member member;

    @Column(columnDefinition = "TEXT")
    private String contents;    // private Member member; 방법
    @Column(nullable = false)
    private boolean check;

    @Builder
    public Todo(Member member, String contents, boolean check) {
        this.member = member;
        this.contents = contents;
        this.check = check;
    }



}