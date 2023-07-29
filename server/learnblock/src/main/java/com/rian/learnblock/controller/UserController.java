package com.rian.learnblock.controller;

import com.rian.learnblock.bean.UserRequest;
import com.rian.learnblock.bean.UserResponse;
import com.rian.learnblock.entity.User;
import com.rian.learnblock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("v1/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        UserResponse createdUser = userService.createUser(userRequest);

        if (createdUser == null) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @GetMapping("email")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {

        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<User> getUserById(@RequestParam String id) {
        System.out.println(id);
        User user = userService.getUserById(id);
        System.out.println(userService.getUserById(id));
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam String id) {
        userService.deleteUser(id);
    }

}
