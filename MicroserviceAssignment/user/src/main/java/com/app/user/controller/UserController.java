package com.app.user.controller;

import com.app.user.dto.ErrorDto;
import com.app.user.dto.UserDto;
import com.app.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<UserDto> userDtos = null;
        try {
            userDtos = userService.getAllUsers();
            return ResponseEntity.ok(userDtos);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ErrorDto(HttpStatus.BAD_REQUEST, e.getMessage(), new Date()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        UserDto userDto = null;
        try {
            userDto = userService.getUserById(id);
            return ResponseEntity.ok(userDto);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ErrorDto(HttpStatus.BAD_REQUEST, e.getMessage(), new Date()));
        }
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
        try {
            List<UserDto> userDtos = userService.addUser(userDto);
            return ResponseEntity.ok(userDtos);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ErrorDto(HttpStatus.BAD_REQUEST, e.getMessage(), new Date()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
        try {
            List<UserDto> userDtos = userService.deleteUserById(id);
            return ResponseEntity.ok(userDtos);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ErrorDto(HttpStatus.BAD_REQUEST, e.getMessage(), new Date()));
        }
    }

    @PutMapping
    public ResponseEntity<?> editUser(@RequestBody UserDto userDto) {
        try {
            List<UserDto> userDtos = userService.editUser(userDto);
            return ResponseEntity.ok(userDtos);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ErrorDto(HttpStatus.BAD_REQUEST, e.getMessage(), new Date()));
        }
    }
}
