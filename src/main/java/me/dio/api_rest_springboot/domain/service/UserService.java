package me.dio.api_rest_springboot.domain.service;

import me.dio.api_rest_springboot.domain.dto.user.UserRequestDTO;
import me.dio.api_rest_springboot.domain.dto.user.UserResponseDTO;

import me.dio.api_rest_springboot.domain.model.Feature;
import me.dio.api_rest_springboot.domain.model.News;
import me.dio.api_rest_springboot.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponseDTO findById(UUID id);

    User create(UserRequestDTO userRequest);

    List<Feature> findAllUserFeatures(UUID id);

    List<News> findAllUserNews(UUID id);

    void delete(UUID id);

    UserResponseDTO update(UUID id, UserRequestDTO userRequest);
}
