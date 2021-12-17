package com.springboot.security.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;


//Don't need this class
public class Authenticated {
    public static String isAuthenticated() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "sdf";
        //System.out.println(isAuthenticated());
 /*       if (principal instanceof UserDetails) {
            return (UserDetails)principal).getUsername();
        } else {
            return principal.toString();
        }*/
        /*final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return null != authentication && !("anonymousUser").equals(authentication.getName());*/
    }
}
