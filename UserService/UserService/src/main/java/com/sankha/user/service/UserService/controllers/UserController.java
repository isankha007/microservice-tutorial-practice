package com.sankha.user.service.UserService.controllers;

import com.sankha.user.service.UserService.entities.User;
import com.sankha.user.service.UserService.payload.ApiResponse;
import com.sankha.user.service.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser=userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    //signle user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        User user=userService.getUser(userId);

        return ResponseEntity.ok(user);
    }
//All user
@GetMapping
public ResponseEntity<List<User>> getAllUsers(  ){
    List<User> allUsers=userService.getAllUser();
    return ResponseEntity.ok(allUsers);
}

}
