package com.rian.learnblock.bean;

import lombok.Data;

import java.math.BigInteger;

@Data
public class UserResponse {

    private String id;
    private boolean verified;

    private boolean status;

    private String fullname;

    private String email;

    private int code;
}
