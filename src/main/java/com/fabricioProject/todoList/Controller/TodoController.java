package com.fabricioProject.todoList.Controller;

import com.fabricioProject.todoList.Entity.TodoModel;
import com.fabricioProject.todoList.Service.TodoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    List<TodoModel> create(TodoModel todo){
        return todoService.create(todo);
    }

    List<TodoModel> list(){
        return todoService.list();
    }

    List<TodoModel> update(TodoModel todo){
        return todoService.update(todo);
    }
    List<TodoModel> delete(Long id){
        return todoService.delete(id);
    }

}
