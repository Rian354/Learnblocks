package com.rian.learnblock.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginResponse implements Serializable {

    private String id;
    private String fullname;
    private String email;

    private boolean status;

    private boolean isVerified;
}
