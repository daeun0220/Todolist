package com.example.todolist.domain;

import com.example.todolist.dto.TodoUpdateRequestDto;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Todo")

public class Todo {
    @Id  // PK 매핑
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")   // column 은 이름이나 제한 정할거 있을 때 사용. 필수 아님
    private Long id;

    @ManyToOne  // 관계매핑을 위한 어노테이션
    @JoinColumn(name = "member_id", referencedColumnName = "member_id") //member 테이블에서의 이름
    private Member member;

    private String contents;    // private Member member; 방법

    private boolean flag;   // TODO: check 사용하면 안되는 이유. sql 문에서 오류난다.

    @Builder
    public Todo(Member member, String contents, boolean flag) {
        this.member = member;
        this.contents = contents;
        this.flag = flag;
    }

    public void update(TodoUpdateRequestDto dto) {
        this.contents = dto.getContents();
        this.flag = dto.isFlag();
    }

    public void flagUpdate(boolean flag) {
        this.flag = flag;
    }

}