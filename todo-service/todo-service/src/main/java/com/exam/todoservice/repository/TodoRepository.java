package com.exam.todoservice.repository;

import com.exam.todoservice.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends CrudRepository<Todo,Integer> {

    Optional<List<Todo>> findByUser(Integer integer);
}
