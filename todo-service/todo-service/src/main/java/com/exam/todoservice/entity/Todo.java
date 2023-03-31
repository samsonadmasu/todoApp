package com.exam.todoservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "todo")
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String description;
    private Integer user;

    public Todo() {
    }

    public Todo(String name, String description, Integer user) {
        this.name = name;
        this.description = description;
        this.user= user;
    }
}
