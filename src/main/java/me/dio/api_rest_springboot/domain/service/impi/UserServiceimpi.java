package me.dio.api_rest_springboot.domain.service.impi;

import me.dio.api_rest_springboot.domain.dto.user.UserRequestDTO;
import me.dio.api_rest_springboot.domain.dto.user.UserResponseDTO;

import me.dio.api_rest_springboot.domain.mapper.UserMapper;

import me.dio.api_rest_springboot.domain.model.Feature;
import me.dio.api_rest_springboot.domain.model.News;
import me.dio.api_rest_springboot.domain.model.User;

import me.dio.api_rest_springboot.domain.repository.UserRepository;
import me.dio.api_rest_springboot.domain.service.UserService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class UserServiceimpi implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceimpi(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

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

    @Override
    public List<Feature> findAllUserFeatures(UUID id){
        User user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return user.getFeatures();
    }

    @Override
    public List<News> findAllUserNews(UUID id){
        User user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return user.getNews();
    }
}