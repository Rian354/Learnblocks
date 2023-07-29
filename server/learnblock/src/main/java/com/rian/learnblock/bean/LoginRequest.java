package com.rian.learnblock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginRequest implements Serializable {

    private String password;

    private String email;
}
