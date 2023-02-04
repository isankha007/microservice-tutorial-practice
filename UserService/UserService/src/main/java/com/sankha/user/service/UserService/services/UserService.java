package com.sankha.user.service.UserService.services;

import com.sankha.user.service.UserService.entities.User;

import java.util.List;

public interface UserService {

    //create
    User saveUser(User user);

    //get
    List<User> getAllUser();

    User getUser(String userId);

    ///delete

    void deleteUser(String userId);

    //update
    User updateUser(User user);
}
