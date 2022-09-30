package com.example.todolist.repository;

import com.example.todolist.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 스프링이 자동으로 json 으로 반환해서 준다....?
@Repository  // 안붙여도되는데 보기 좋으라고.
public interface MemberRepository extends JpaRepository<Member, Long> {
}
