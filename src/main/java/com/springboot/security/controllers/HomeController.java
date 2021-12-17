package com.springboot.security.controllers;

import java.security.Principal;

import com.springboot.security.security.SecurityConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static com.springboot.security.security.Authenticated.isAuthenticated;

@Controller
class HomeController {

    Principal principal = null;

    @GetMapping("/")
    public String home(final Principal principal) {
        System.out.println(isAuthenticated());
/*        if (principal.getName() == null)
            System.out.println("Username: null");
        else */
        //System.out.println("Username: " + principal.getName());
        return "home";
    }

    @GetMapping({"/login"})
    public String login() {
        return "login";
    }

    @GetMapping({"/user", "/admin"})
    public String loggedin(final Principal principal) {
        System.out.println("Username: " + principal.getName());
        System.out.println(isAuthenticated());
        return "loggedin";
    }
}
