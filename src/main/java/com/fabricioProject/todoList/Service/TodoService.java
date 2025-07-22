package com.fabricioProject.todoList.Service;

import com.fabricioProject.todoList.Entity.TodoModel;
import com.fabricioProject.todoList.Repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<TodoModel> create(TodoModel todoModel){
        todoRepository.save(todoModel);
        return list();
    }

    public List<TodoModel> list(){
        Sort sort = Sort.by("priority").descending().and(
                Sort.by("name").ascending());
        return todoRepository.findAll(sort);
    }

    public List<TodoModel> update(TodoModel todoModel){
        todoRepository.save(todoModel);
        return list();
    }

    public List<TodoModel> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }

}
