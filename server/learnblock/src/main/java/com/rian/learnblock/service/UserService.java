package com.rian.learnblock.service;


import com.rian.learnblock.bean.LoginRequest;
import com.rian.learnblock.bean.LoginResponse;
import com.rian.learnblock.bean.UserRequest;
import com.rian.learnblock.bean.UserResponse;
import com.rian.learnblock.entity.User;


public interface UserService {

    UserResponse createUser(UserRequest userRequest);

    User getUserById(String id);

    User getUserByEmail(String email);

    void deleteUser(String id);

    LoginResponse login(LoginRequest bean);
}

