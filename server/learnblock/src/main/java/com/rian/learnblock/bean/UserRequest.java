package com.rian.learnblock.bean;

import lombok.Data;

/**
 * @Author Rian Atri
 * @Version 1.0
 */
@Data
public class UserRequest {

    private String id;
    private boolean verified;

    private boolean status;

    private String fullname;

    private String email;

    private String password;

    private int code;

}
