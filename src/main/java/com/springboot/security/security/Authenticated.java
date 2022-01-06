package com.springboot.security.security;

import org.springframework.security.core.context.SecurityContextHolder;

//Returns true for logged in, false otherwise
public class Authenticated {

    //Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 

    //Add token check?
    public static boolean isAuth() {
        String userName = getUsername();
        if(userName != "anonymousUser") {
            return true;
        } else {
            return false; 
        }
    }

    public static String getUsername() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return userName;
    }
}
