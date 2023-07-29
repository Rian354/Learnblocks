package com.rian.learnblock.controller;

import com.rian.learnblock.bean.LoginRequest;
import com.rian.learnblock.bean.LoginResponse;
import com.rian.learnblock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/login")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<LoginResponse> getUserById(@RequestBody LoginRequest loginRequest) {

        if (loginRequest == null || loginRequest.getPassword() == null || loginRequest.getEmail() == null
                || loginRequest.getEmail().isEmpty() || loginRequest.getPassword().isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        try {
            LoginResponse loginResponse = userService.login(loginRequest);
            if (loginResponse != null) {
                return new ResponseEntity<>(loginResponse, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

}
