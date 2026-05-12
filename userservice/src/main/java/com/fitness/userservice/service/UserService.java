package com.fitness.userservice.service;

import com.fitness.userservice.controller.dto.RegisterRequest;
import com.fitness.userservice.controller.dto.UserResponse;
import com.fitness.userservice.model.User;
import com.fitness.userservice.repository.UserRepository;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public @ Nullable UserResponse register(@Valid RegisterRequest request) {

        if(repository.existsByEmail(request.getEmail()))  // User already exist in DB
        {
            throw new RuntimeException("Email already exists");
        }

        User user  = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        User savedUSer = repository.save(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setId(savedUSer.getId());
        userResponse.setEmail(savedUSer.getEmail());
        userResponse.setPassword(savedUSer.getPassword());
        userResponse.setFirstName(savedUSer.getFirstName());
        userResponse.setLastName(savedUSer.getLastName());
        userResponse.setCreatedAt(savedUSer.getCreatedAt());
        userResponse.setUpdatedAt(savedUSer.getUpdatedAt());
        return userResponse;
    }

    public @Nullable UserResponse getUserProfile(String userId) {
        User user =  repository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());

        return userResponse;
    }

    public Boolean existByUserId(String userId) {
        return  repository.existsById(userId);
    }
}
