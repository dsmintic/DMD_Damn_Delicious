package com.example.dmd_damn_delicious.controller;

import com.example.dmd_damn_delicious.model.User;
import com.example.dmd_damn_delicious.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserControllerRest {

    private UserService userService;

    @Autowired
    public UserControllerRest(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        try {
            User user1 = userService.saveUser(new User(user.getUsername(), user.getPassword(), user.isRole()));
            return new ResponseEntity<>(user1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(String username) {
        try {
            List<User> users = new ArrayList<>();

            if(username == null ) {
                users = userService.getAllUsers();
            } else {
                //create a method that will filter by title
                users = userService.getUserByUsername(username);
            }
            // get a list of tutorials from database

            if(users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        //method to return tutorial by id from database
        User user = userService.getUserByID(id);

        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/users/{id}") // PUT in REST API
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        User user1 = userService.getUserByID(id);
        if(user1 != null ) {
            user1.setUsername(user.getUsername());
            user1.setPassword(user.getPassword());
            user1.setRole(user.isRole());
            return new ResponseEntity<>(userService.saveUser(user1), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping ("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id){
        try {
            userService.deletePersonById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
