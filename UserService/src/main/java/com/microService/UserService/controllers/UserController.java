package com.microService.UserService.controllers;

import com.microService.UserService.entities.User;
import com.microService.UserService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userservice;

//    Save User
    @Transactional
    @PostMapping("/add-User")
    public User createUser (@RequestBody User user){
        User Saveduser = userservice.saveUser(user);
        return Saveduser;
    }

    //get UserById
    @GetMapping("/getUser/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker")
    public User getUserById(@PathVariable int userId) {
            User user = userservice.getUserById(userId);
            return user;
    }

    //getAllUser
    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUser = userservice.getAllUser();
        return ResponseEntity.ok(allUser);
    }

}
