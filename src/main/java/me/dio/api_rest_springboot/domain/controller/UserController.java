package me.dio.api_rest_springboot.domain.controller;

import me.dio.api_rest_springboot.domain.dto.user.UserRequestDTO;
import me.dio.api_rest_springboot.domain.dto.user.UserResponseDTO;

import me.dio.api_rest_springboot.domain.model.Feature;
import me.dio.api_rest_springboot.domain.model.News;
import me.dio.api_rest_springboot.domain.service.UserService;
import me.dio.api_rest_springboot.domain.model.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable UUID id){
        UserResponseDTO user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}/features")
    public ResponseEntity<List<Feature>> getFeatures(@PathVariable UUID id){
        List<Feature> features = userService.findAllUserFeatures(id);
        return ResponseEntity.ok(features);
    }

    @GetMapping("/{id}/news")
    public ResponseEntity<List<News>> getNews(@PathVariable UUID id){
        List<News> news = userService.findAllUserNews(id);
        return ResponseEntity.ok(news);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserRequestDTO user){
        User newUser = userService.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(location).body(newUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        userService.delete(id);
        return ResponseEntity.ok("User deleted successfully.");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable UUID id, @RequestBody UserRequestDTO user){
        UserResponseDTO userResponse = userService.update(id, user);
        return ResponseEntity.ok(userResponse);
    }
}