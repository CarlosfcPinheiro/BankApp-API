package me.dio.api_rest_springboot.domain.service;

import me.dio.api_rest_springboot.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User user);
}
