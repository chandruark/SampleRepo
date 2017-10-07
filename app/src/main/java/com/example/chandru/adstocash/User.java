package com.example.chandru.adstocash;

/**
 * Created by chandru on 10/7/2017.
 */

public class User {

    private String name;
    private String email;
    private String password;
    private long phno;
    private int gender;

    private String message;
    private String auth_token;

    public User(String name, String email, String password, long phno, int gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phno = phno;
        this.gender = gender;
    }

    public String getMessage(){
        return message;
    }
    public String getAuth_token(){
        return auth_token;
    }

}
