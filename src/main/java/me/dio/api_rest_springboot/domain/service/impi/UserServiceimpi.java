package me.dio.api_rest_springboot.domain.service.impi;

import me.dio.api_rest_springboot.domain.dto.user.UserRequestDTO;
import me.dio.api_rest_springboot.domain.dto.user.UserResponseDTO;
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

    private final UserMapper userMapper;
    // Injection UserRepository via class constructor
    public UserServiceimpi(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // Implementing methods
    @Override
    public UserResponseDTO findById(UUID id){
        User user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return userMapper.toUserResponseDTO(user);
    }

    @Override
    public User create(UserRequestDTO userRequest){
        User userToCreate = userMapper.toEntity(userRequest);
        UUID currentId = userToCreate.getId();
        if (currentId != null && userRepository.existsById(currentId)){
            throw new IllegalArgumentException("User ID already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
