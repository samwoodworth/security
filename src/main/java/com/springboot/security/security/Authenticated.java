package com.springboot.security.security;

import com.springboot.security.repo.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.springboot.security.model.User;


//Returns true for logged in, false otherwise
public class Authenticated {

    //Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
    UserRepo userRepo;


    public static boolean isAuth() {
        String userName = getUsername();
        if(userName != "anonymousUser") {
            
            return true;
        }

        else    
            return false; 
        }

    public static String getUsername() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return userName;
    }
}
