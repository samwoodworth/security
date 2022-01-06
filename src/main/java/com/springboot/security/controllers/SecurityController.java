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

    private final UserRepo repo;
    boolean loggedIn = false;
    String userName = "anonymousUser";

    SecurityController(UserRepo repo) {
        this.repo = repo;
    }

    public String userNameCheck(String newUserName) {
        System.out.println("userName in userNameCheck is: " + userName);
        System.out.println("newUserName in userNameCheck is: " + newUserName);

        if (userName.equals(newUserName)) {
            System.out.println("Both usernames are equal.");
            return userName;
        }
        else {
            userName = newUserName;
            System.out.println("New userName in else of userNameCheck is: " + userName);
            return userName;
        }
    }

    @RequestMapping("/")
    public String home() {
        String newUserName = Authenticated.getUsername();
        System.out.println("Username at /: " + newUserName);

        if(!newUserName.equals("anonymousUser")) {
            User foundUser = repo.findByUserName(newUserName)
                    .orElseThrow(() -> new UserNotFoundException(newUserName));

            foundUser.setLoggedIn(Authenticated.isAuth());
            repo.save(foundUser);
        }
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        String newUserName = Authenticated.getUsername();
        System.out.println("Username at /login: " + newUserName);

        if(!newUserName.equals("anonymousUser")) {
            User foundUser = repo.findByUserName(newUserName)
                    .orElseThrow(() -> new UserNotFoundException(newUserName));

            foundUser.setLoggedIn(Authenticated.isAuth());
            repo.save(foundUser);
            System.out.println("After repo save");
        }
        return "login";
    }

    @RequestMapping("/home")
    public String loggedin() {
        String newUserName = Authenticated.getUsername();
        System.out.println("Username at /home: " + newUserName);

        if(!newUserName.equals("anonymousUser")) {
            User foundUser = repo.findByUserName(newUserName)
                    .orElseThrow(() -> new UserNotFoundException(newUserName));
            foundUser.setLoggedIn(Authenticated.isAuth());
            repo.save(foundUser);
        }
        return "loggedin";
    }

    @GetMapping("/getAuth")
    public @ResponseBody String  getAuth(@RequestParam String user) {

        User foundUser = repo.findByUserName(user)
            .orElseThrow(() -> new UserNotFoundException(user));
        System.out.println("Get Auth logged in status: " + foundUser.isLoggedIn());
        String isLoggedInStr = String.valueOf(foundUser.isLoggedIn());
        return isLoggedInStr;
    }
}
