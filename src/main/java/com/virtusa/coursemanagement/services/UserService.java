package com.virtusa.coursemanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.coursemanagement.models.User;
import com.virtusa.coursemanagement.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User createUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        // existingUser.ifPresent(throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists!"));
        if(existingUser.isPresent()) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists!");
        }
        return userRepository.save(user);
    }

    // public User add(User user) {
    //     User existingUser = userRepository.getByEmail(user.getEmail());
    //     if (existingUser != null) {
    //         throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists!");
    //     }
    //     return userRepository.save(user);
    // }

    public User updateUser(Long id, User user) {
        Optional<User> userToUpdate = userRepository.findById(id);
        if(userToUpdate.isPresent()) {
            User existingUser = userToUpdate.get();
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setRole(user.getRole());
            return userRepository.save(existingUser);
        }
        return null;
        // return userRepository.update(id, existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
