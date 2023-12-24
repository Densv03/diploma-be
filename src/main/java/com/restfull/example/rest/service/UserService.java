package com.restfull.example.rest.service;

import com.restfull.example.rest.entety.UserEntity;
import com.restfull.example.rest.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDto);

    UserDto getUser(String email);

    UserEntity getUserEmailById(UUID userId);
}
