package com.app.todo.controller;

import com.app.todo.dto.ErrorDto;
import com.app.todo.dto.TodoDto;
import com.app.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<?> getAllTodo() {
        List<TodoDto> todoDtos = null;
        try {
            todoDtos = todoService.getAllTodo();
            return ResponseEntity.ok(todoDtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorDto(HttpStatus.BAD_REQUEST, e.getMessage(), new Date()));
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getTodoByUserId(@PathVariable Long userId) {
        List<TodoDto> todoDtos = null;
        try {
            todoDtos = todoService.getTodoByUserId(userId);
            return ResponseEntity.ok(todoDtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorDto(HttpStatus.BAD_REQUEST, e.getMessage(), new Date()));
        }
    }

    @PostMapping
    public ResponseEntity<?> addTodo(@RequestBody TodoDto todoDto) {
        List<TodoDto> todoDtos = null;
        try {
            todoDtos = todoService.addTodo(todoDto);
            return ResponseEntity.ok(todoDtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorDto(HttpStatus.BAD_REQUEST, e.getMessage(), new Date()));
        }
    }

    @PutMapping
    public ResponseEntity<?> editTodo(@RequestBody TodoDto todoDto) {
        List<TodoDto> todoDtos = null;
        try {
            todoDtos = todoService.editTodo(todoDto);
            return ResponseEntity.ok(todoDtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorDto(HttpStatus.BAD_REQUEST, e.getMessage(), new Date()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodoById(@PathVariable Long id) {
        List<TodoDto> todoDtos = null;
        try {
            todoDtos = todoService.deleteTodoById(id);
            return ResponseEntity.ok(todoDtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorDto(HttpStatus.BAD_REQUEST, e.getMessage(), new Date()));
        }
    }
}
