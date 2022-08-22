package com.app.todo.service;

import com.app.todo.dto.TodoDto;

import java.util.List;

public interface TodoService {
    List<TodoDto> getAllTodo();

    List<TodoDto> getTodoByUserId(Long userId);

    List<TodoDto> addTodo(TodoDto todoDto);

    List<TodoDto> editTodo(TodoDto todoDto);

    List<TodoDto> deleteTodoById(Long id);
}
