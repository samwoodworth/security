package com.springboot.security.controllers;

import java.security.Principal;

import com.springboot.security.security.SecurityConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping({"/login"})
    public String login() {
        return "login";
    }

    @GetMapping({"/user", "/admin"})
    public String loggedin(final Principal principal) {
        if (null == principal) return "login";
        return "loggedin";
    }
}
