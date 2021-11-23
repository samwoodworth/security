package com.springboot.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//Only use controller not restcontroller
@Controller
class HomeController {
    
    @GetMapping("/")
    public String home() {
        return ("home");
    }

    @GetMapping({"/login"})
    public String login() {
        return "login";
    }

    @GetMapping({"/user", "/admin"})
    public String loggedin() {
        return "loggedin";
    }
}
