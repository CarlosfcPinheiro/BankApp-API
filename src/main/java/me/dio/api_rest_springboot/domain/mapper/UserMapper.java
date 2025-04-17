package me.dio.api_rest_springboot.domain.mapper;

import me.dio.api_rest_springboot.domain.dto.user.UserRequestDTO;
import me.dio.api_rest_springboot.domain.dto.user.UserResponseDTO;

import me.dio.api_rest_springboot.domain.model.User;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {
    public UserResponseDTO toUserResponseDTO(User user){
        UserResponseDTO userDTO = new UserResponseDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAccount(user.getAccount());
        userDTO.setCard(user.getCard());

        return userDTO;
    }

    public UserResponseDTO toUserResponseDTO(UUID id, UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(id);
        userResponseDTO.setName(userRequestDTO.getName());
        userResponseDTO.setAccount(userRequestDTO.getAccount());
        userResponseDTO.setCard(userRequestDTO.getCard());
        return userResponseDTO;
    }

    public User toEntity(UserRequestDTO userRequestDTO){
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setAccount(userRequestDTO.getAccount());
        user.setCard(userRequestDTO.getCard());
        user.setNews(userRequestDTO.getNews());
        user.setFeatures(userRequestDTO.getFeatures());

        return user;
    }

    public User toEntity(UserResponseDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setAccount(userDTO.getAccount());
        user.setCard(userDTO.getCard());

        return user;
    }
}
