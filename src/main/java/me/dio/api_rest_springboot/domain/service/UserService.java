package me.dio.api_rest_springboot.domain.service;

import me.dio.api_rest_springboot.domain.dto.user.UserRequestDTO;
import me.dio.api_rest_springboot.domain.dto.user.UserResponseDTO;
import me.dio.api_rest_springboot.domain.model.User;

import java.util.UUID;

public interface UserService {
    UserResponseDTO findById(UUID id);

    User create(UserRequestDTO userRequest);
}
