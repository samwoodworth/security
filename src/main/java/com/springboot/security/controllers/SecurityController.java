package com.springboot.security.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.springboot.security.security.Authenticated.isAuthenticated;

@Controller
class SecurityController {

    @RequestMapping("/")
    public String home(final Principal principal) {
        System.out.println("Username at home: " + isAuthenticated());
        return "home";
    }

    @RequestMapping({"/login"})
    public String login(final Principal principal) {
        System.out.println("Username at login: " + isAuthenticated());
        return "login";
    }

    @RequestMapping({"/home"})
    public String loggedin(final Principal principal) {
        System.out.println("Username after logged in: " + isAuthenticated());
        return "loggedin";
    }
}
