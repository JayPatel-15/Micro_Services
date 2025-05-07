package com.microService.UserService.services;

import com.microService.UserService.entities.User;

import java.util.List;

public interface UserService {

    //user operations

    //create
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get single user of given userId

    User getUserById(int userId);

    //TODO: delete
    //TODO: update
}
