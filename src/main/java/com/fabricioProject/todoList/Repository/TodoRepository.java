package com.fabricioProject.todoList.Repository;

import com.fabricioProject.todoList.Entity.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoModel, Long> {

}
