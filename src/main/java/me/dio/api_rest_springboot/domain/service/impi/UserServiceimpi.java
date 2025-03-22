package me.dio.api_rest_springboot.domain.service.impi;

import me.dio.api_rest_springboot.domain.dto.UserDTO;
import me.dio.api_rest_springboot.domain.mapper.UserMapper;
import me.dio.api_rest_springboot.domain.model.User;
import me.dio.api_rest_springboot.domain.repository.UserRepository;
import me.dio.api_rest_springboot.domain.service.UserService;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class UserServiceimpi implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMpper;
    // Injection UserRepository via class constructor
    public UserServiceimpi(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMpper = userMapper;
    }

    // Implementing methods
    @Override
    public UserDTO findById(UUID id){
        User user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return userMpper.toUserDTO(user);
    }

    @Override
    public User create(User userToCreate){
        UUID currentId = userToCreate.getId();
        if (currentId != null && userRepository.existsById(currentId)){
            throw new IllegalArgumentException("User ID already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
