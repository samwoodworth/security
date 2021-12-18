package com.springboot.security.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static com.springboot.security.security.Authenticated.isAuthenticated;

@Controller
class HomeController {

    @GetMapping("/")
    public String home(final Principal principal) {
        System.out.println("Username: " + isAuthenticated());
        return "home";
    }

    @GetMapping({"/login"})
    public String login(final Principal principal) {
        System.out.println("Username: " + isAuthenticated());
        return "login";
    }

    @GetMapping({"/user", "/admin"})
    public String loggedin(final Principal principal) {
        System.out.println("Username: " + isAuthenticated());
        return "loggedin";
    }
}
