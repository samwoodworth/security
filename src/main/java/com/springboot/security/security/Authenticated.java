package com.springboot.security.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class Authenticated {

    //Add token check?
    public static boolean isAuth() {
        String userName = getUsername();
        //return !userName.equals("anonymousUser");
        return true;
    }

    public static String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
