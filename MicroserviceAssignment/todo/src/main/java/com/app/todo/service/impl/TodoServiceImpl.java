package com.app.todo.service.impl;

import com.app.todo.dto.TodoDto;
import com.app.todo.dto.UserDto;
import com.app.todo.entity.Todo;
import com.app.todo.repository.TodoRepository;
import com.app.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String USER_SERVICE_URI = "http://localhost:8080/user/";

    @Override
    public List<TodoDto> getAllTodo() {
        List<Todo> todos = todoRepository.findAll();
        return convertTodoListToTodoDtoList(todos);
    }

    @Override
    public List<TodoDto> getTodoByUserId(Long userId) {
        List<Todo> todos = todoRepository.findAllByUserId(userId);
        return convertTodoListToTodoDtoList(todos);
    }

    private List<TodoDto> convertTodoListToTodoDtoList(List<Todo> todos) {
        List<TodoDto> todoDtos = new ArrayList<>();
        for (Todo todo: todos) {
            UserDto userDto = restTemplate.getForObject(USER_SERVICE_URI+todo.getUserId(), UserDto.class);
            TodoDto todoDto = new TodoDto(
                    todo.getId(),
                    todo.getTitle(),
                    todo.getDescription(),
                    todo.getScheduleDate(),
                    todo.getCreatedDate(),
                    todo.getCreatedBy(),
                    todo.getLastModifiedDate(),
                    todo.getLastModifiedBy(),
                    userDto
            );
            todoDtos.add(todoDto);
        }
        return todoDtos;
    }

    private Todo convertTodoDtoToTodo(TodoDto todo) {
        return new Todo(
                todo.getTitle(),
                todo.getDescription(),
                todo.getUser().getId(),
                todo.getScheduleDate(),
                todo.getCreatedDate() != null? todo.getCreatedDate(): new Date(),
                todo.getCreatedBy(),
                todo.getLastModifiedDate() != null? todo.getLastModifiedDate(): new Date(),
                todo.getLastModifiedBy()
        );
    }

    private TodoDto convertTodoToTodoDto(Todo todo) {
        UserDto userDto = restTemplate.getForObject(USER_SERVICE_URI+todo.getUserId(), UserDto.class);
        return new TodoDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getScheduleDate(),
                todo.getCreatedDate() != null? todo.getCreatedDate(): new Date(),
                todo.getCreatedBy(),
                todo.getLastModifiedDate() != null? todo.getLastModifiedDate(): new Date(),
                todo.getLastModifiedBy(),
                userDto
        );
    }

    @Override
    public List<TodoDto> addTodo(TodoDto todoDto) {
        todoRepository.save(convertTodoDtoToTodo(todoDto));
        return getTodoByUserId(todoDto.getUser().getId());
    }

    @Override
    public List<TodoDto> editTodo(TodoDto todoDto) {
        Todo todo = todoRepository.findById(todoDto.getId()).get();
        if(todoDto.getTitle()!= null) {
            todo.setTitle(todoDto.getTitle());
        }
        if(todoDto.getDescription() != null) {
            todo.setDescription(todo.getDescription());
        }
        if(todoDto.getScheduleDate() != null){
            todo.setScheduleDate(todoDto.getScheduleDate());
        }
        todo.setLastModifiedDate(new Date());
        todoRepository.save(todo);
        return getTodoByUserId(todo.getUserId());
    }

    @Override
    public List<TodoDto> deleteTodoById(Long id) {
        Todo todo = todoRepository.findById(id).get();
        todoRepository.deleteById(id);
        return getTodoByUserId(todo.getUserId());
    }
}
