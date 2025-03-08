package me.dio.api_rest_springboot.domain.service.impi;

import me.dio.api_rest_springboot.domain.model.User;
import me.dio.api_rest_springboot.domain.repository.UserRepository;
import me.dio.api_rest_springboot.domain.service.UserService;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceimpi implements UserService {

    private final UserRepository userRepository;
    // Injection UserRepository via class constructor
    public UserServiceimpi(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Implementing methods
    @Override
    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate){
        Long currentId = userToCreate.getId();
        if (currentId != null && userRepository.existsById(currentId)){
            throw new IllegalArgumentException("User ID already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
