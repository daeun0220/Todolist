package com.example.todolist.repository;

import com.example.todolist.domain.Member;
import com.example.todolist.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByOrderByIdDesc();

    // JPQL
    @Query("select t from Todo t where t.member.id = :memberId")
    List<Todo> findByMember(@Param("memberId") Long memberId);

}
