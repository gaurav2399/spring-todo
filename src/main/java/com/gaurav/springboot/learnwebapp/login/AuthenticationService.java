package com.gaurav.springboot.learnwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean isValidUser(String username, String password){
        boolean isValidUsername = username.equalsIgnoreCase("gaurav");
        boolean isValidPassword = password.equalsIgnoreCase("12345");
        return isValidPassword && isValidUsername;
    }

}
