package com.restfull.example.rest.controller;

import com.restfull.example.rest.entety.UserEntity;
import com.restfull.example.rest.model.request.UserRequest;
import com.restfull.example.rest.response.UserResponse;
import com.restfull.example.rest.repository.UserRepository;
import com.restfull.example.rest.service.UserServiceImpl;
import com.restfull.example.rest.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
@CrossOrigin()
public class UserController {

    private final UserRepository userRepository;

    private final UserServiceImpl userService;

    public UserController(UserRepository userRepository, UserServiceImpl userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) {
        UserResponse response = new UserResponse();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(request, userDto);
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, response);
        return response;
    }


    @GetMapping
    public ResponseEntity<List<UserEntity>> listUser() {
        final Iterable<UserEntity> all = userRepository.findAll();
        List<UserEntity> result = new ArrayList<>();
        all.forEach(result::add);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/currentUser")
    public ResponseEntity<UserEntity> getUser(@RequestHeader("UserId") final UUID uuid) {
        final UserEntity user = userRepository.findByUserId(uuid);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllUsers() {
        userRepository.deleteAll();
        return ResponseEntity.ok("DELETE");
    }
}
