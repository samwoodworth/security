package com.springboot.security.controllers;

import com.springboot.security.repo.UserRepo;
import com.springboot.security.security.Authenticated;
import com.springboot.security.exceptions.UserNotFoundException;
import com.springboot.security.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class SecurityController {

    private final UserRepo repo;
    boolean loggedIn = false;

    //Creates extra, null user
    User foundUser = new User();

    SecurityController(UserRepo repo) {
        this.repo = repo;
    }

    @RequestMapping("/")
    public String home() {
        String newUserName = Authenticated.getUsername();
        System.out.println(newUserName);
        if(!newUserName.equals("anonymousUser")) {
            foundUser = repo.findByUserName(newUserName)
                    .orElseThrow(() -> new UserNotFoundException(newUserName));

            loggedIn = Authenticated.isAuth();
            foundUser.setLoggedIn(loggedIn);
            repo.save(foundUser);
        } else {
            loggedIn = false;
            foundUser.setLoggedIn(false);
            repo.save(foundUser);
        }
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        String newUserName = Authenticated.getUsername();

        if(!newUserName.equals("anonymousUser")) {
            foundUser = repo.findByUserName(newUserName)
                    .orElseThrow(() -> new UserNotFoundException(newUserName));
            loggedIn = Authenticated.isAuth();
            foundUser.setLoggedIn(loggedIn);
            repo.save(foundUser);
        } else {
            loggedIn = false;
            foundUser.setLoggedIn(false);
            repo.save(foundUser);
        }
        return "login";
    }

    @RequestMapping("/home")
    public String loggedin() {
        String newUserName = Authenticated.getUsername();

        if(!newUserName.equals("anonymousUser")) {
            foundUser = repo.findByUserName(newUserName)
                    .orElseThrow(() -> new UserNotFoundException(newUserName));
            loggedIn = Authenticated.isAuth();
            foundUser.setLoggedIn(loggedIn);
            repo.save(foundUser);
        } else {
            loggedIn = false;
            foundUser.setLoggedIn(false);
            repo.save(foundUser);
        }
        return "loggedin";
    }

    @GetMapping("/getAuth")
    public @ResponseBody String  getAuth(@RequestParam String user) {

        User foundUser = repo.findByUserName(user)
            .orElseThrow(() -> new UserNotFoundException(user));
        return String.valueOf(foundUser.isLoggedIn());
    }
}
