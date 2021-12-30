package com.springboot.security.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


//Returns true for logged in, false otherwise
public class Authenticated {

    //Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 

    public static boolean isAuth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
        if(auth.getName() != "anonymousUser")
            return true;
        else    
            return false; 
        }

    public static String getUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
        return auth.getName();
    }
}
