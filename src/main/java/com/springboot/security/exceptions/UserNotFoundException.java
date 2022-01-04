package com.springboot.security.exceptions;

public class UserNotFoundException extends RuntimeException{
    
    public UserNotFoundException(String userName) {
        super("Could not find user: " + userName);
    }
}
