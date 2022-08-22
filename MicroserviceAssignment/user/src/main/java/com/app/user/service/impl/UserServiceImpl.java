package com.app.user.service.impl;

import com.app.user.dto.UserDto;
import com.app.user.entity.User;
import com.app.user.repository.UserRepository;
import com.app.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(user -> new UserDto(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getMobile(),
                user.getCreatedBy(),
                user.getLastModifiedBy()
        )).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).get();
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getMobile(),
                user.getCreatedBy(),
                user.getLastModifiedBy()
        );
    }

    @Override
    public List<UserDto> addUser(UserDto userDto) {
        userRepository.save(new User(
                userDto.getEmail(),
                userDto.getName(),
                userDto.getMobile(),
                userDto.getCreatedBy(),
                userDto.getLastModifiedBy()
        ));
        return getAllUsers();
    }

    @Override
    public List<UserDto> deleteUserById(Long id) {
        userRepository.deleteById(id);
        return getAllUsers();
    }

    @Override
    public List<UserDto> editUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).get();
        if (userDto.getEmail() != null) {
            user.setEmail(userDto.getEmail());
        }
        if (userDto.getMobile() != null) {
            user.setMobile(userDto.getMobile());
        }
        if (userDto.getName() != null) {
            user.setName(userDto.getName());
        }
        userRepository.save(user);
        return getAllUsers();
    }
}
