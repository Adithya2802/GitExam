package com.app.user.service;

import com.app.user.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    List<UserDto> addUser(UserDto userDto);

    List<UserDto> deleteUserById(Long id);

    List<UserDto> editUser(UserDto userDto);
}
