package com.fabricioProject.todoList.Controller;

import com.fabricioProject.todoList.Entity.TodoModel;
import com.fabricioProject.todoList.Service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping
    List<TodoModel> create(@RequestBody @Valid TodoModel todo){
        return todoService.create(todo);
    }

    @GetMapping
    List<TodoModel> list(){
        return todoService.list();
    }

    @PutMapping
    List<TodoModel> update(@RequestBody TodoModel todo){
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    List<TodoModel> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }

}
