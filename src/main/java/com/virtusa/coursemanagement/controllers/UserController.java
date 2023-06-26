package com.virtusa.coursemanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.coursemanagement.models.User;
import com.virtusa.coursemanagement.services.UserService;



@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getById(id);
        if(user!=null){
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        // User currentUser = userService.getById(id);
        // if(currentUser == null) {
        //     return null;
        // }
        // currentUser.setName(user.getName());
        // currentUser.setEmail(user.getEmail());
        // currentUser.setPassword(user.getPassword());
        // currentUser.setRole(user.getRole());
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
