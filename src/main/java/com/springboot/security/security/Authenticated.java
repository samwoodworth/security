package com.springboot.security.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;


//Returns true for logged in, false otherwise
public class Authenticated {
    public static boolean isAuthenticated() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
        if(auth.getName() == "anonymousUser")
            return false;
        else
            return true;
    }
}
