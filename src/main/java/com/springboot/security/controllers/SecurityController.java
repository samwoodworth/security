package com.springboot.security.controllers;

import java.security.Principal;

import com.springboot.security.security.Authenticated;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import static com.springboot.security.security.Authenticated.getUsername;
//import static com.springboot.security.security.Authenticated.isAuth;

@Controller
class SecurityController {

    Authenticated auth;

    @RequestMapping("/")
    public String home(final Principal principal) {
        System.out.println("Username at /: " + auth.getUsername());
        System.out.println("Is logged in at /: " + auth.isAuth());
        System.out.println();
        
        return "home";
    }

    @RequestMapping("/login")
    public String login(final Principal principal) {
        System.out.println("Username at /login: " + auth.getUsername());
        System.out.println("Is logged in at /login: " + auth.isAuth());
        System.out.println();
        
        return "login";
    }

    @RequestMapping("/home")
    public String loggedin(final Principal principal) {
        System.out.println("Username at /home: " + auth.getUsername());
        System.out.println("Is logged in at /home: " + auth.isAuth());
        System.out.println();

        return "loggedin";
    }

    @RequestMapping("/getAuth")
    public @ResponseBody boolean getAuth() {
        System.out.println("Username at /getAuth: " + auth.getUsername());
        System.out.println("Is logged in at /getAuth: " + auth.isAuth());
        System.out.println();
        return auth.isAuth();
    }
}
