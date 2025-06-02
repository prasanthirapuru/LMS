package com.lms2025.librarymanagementsystem.service;

import com.lms2025.librarymanagementsystem.model.User;
import com.lms2025.librarymanagementsystem.repository.Userrepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Userservice {

    private final Userrepository userRepository;

    public Userservice(Userrepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public boolean usernameExists(String username) {
        return userRepository.findByUsername(username) != null;
    }   
}
