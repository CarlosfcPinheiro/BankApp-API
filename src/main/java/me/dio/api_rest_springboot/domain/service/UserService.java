package me.dio.api_rest_springboot.domain.service;

import me.dio.api_rest_springboot.domain.dto.UserDTO;
import me.dio.api_rest_springboot.domain.model.User;

import java.util.UUID;

public interface UserService {
    UserDTO findById(UUID id);

    User create(User user);
}
