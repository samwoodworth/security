package com.springboot.security.security;

import org.springframework.security.core.context.SecurityContextHolder;

//Returns true for logged in, false otherwise
public class Authenticated {

    //Add token check?
    public static boolean isAuth() {
        String userName = getUsername();
        return userName.equals("anonymousUser");
    }

    public static String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
