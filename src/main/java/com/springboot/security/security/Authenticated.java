package com.springboot.security.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;


//Returns username for true, anon for false     Change to bool?
public class Authenticated {
    public static String isAuthenticated() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
        return auth.getName();
    }
}
