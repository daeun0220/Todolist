package com.example.todolist.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter @Setter
public class Todo {
    @Id
    private Long id;
    private String name;
    private String list;
    private boolean check;
}