package com.springboot.security.controllers;

import java.security.Principal;

import com.springboot.security.repo.UserRepo;
import com.springboot.security.security.Authenticated;
import com.springboot.security.exceptions.UserNotFoundException;
import com.springboot.security.model.User;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import static com.springboot.security.security.Authenticated.getUsername;
//import static com.springboot.security.security.Authenticated.isAuth;

@Controller
class SecurityController {

    //String username = Authenticated.getUsername();

    private final UserRepo repo;

    SecurityController(UserRepo repo) {
        this.repo = repo;
    }

    @RequestMapping("/")
    public String home() {
        String userName = Authenticated.getUsername();
        System.out.println("Username at /: " + userName);
        System.out.println();
        
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        String userName = Authenticated.getUsername();
        System.out.println("Username at /login: " + userName);
        System.out.println();
        
        return "login";
    }

    @RequestMapping("/home")
    public String loggedin() {
        String userName = Authenticated.getUsername();
        System.out.println("Username at /home: " + userName);
        System.out.println();

        return "loggedin";
    }

    @GetMapping("/getAuth")
    public @ResponseBody String getAuth(@RequestParam String user) {

        User foundUser = repo.findByUserName(user)
            .orElseThrow(() -> new UserNotFoundException(user));

        System.out.println("Is user logged in: " + foundUser.isLoggedIn());
        
        System.out.println("\nUsername at /getAuth: " + user);
        return user;
    }
}
