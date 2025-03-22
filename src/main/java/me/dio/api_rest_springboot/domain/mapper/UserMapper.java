package me.dio.api_rest_springboot.domain.mapper;

import me.dio.api_rest_springboot.domain.dto.UserDTO;
import me.dio.api_rest_springboot.domain.model.User;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAccount(user.getAccount());
        userDTO.setCard(user.getCard());

        return userDTO;
    }

    public User toEntity(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setAccount(userDTO.getAccount());
        user.setCard(userDTO.getCard());

        return user;
    }
}
