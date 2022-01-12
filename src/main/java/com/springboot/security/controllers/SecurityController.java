package com.springboot.security.controllers;

import com.springboot.security.repo.UserRepo;
import com.springboot.security.security.Authenticated;
import com.springboot.security.exceptions.UserNotFoundException;
import com.springboot.security.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class SecurityController {

    private final UserRepo repo;
    boolean loggedIn = false;
    String token;

    //Creates extra, null user in db
    //@Autowired
    User foundUser = new User();

    SecurityController(UserRepo repo) {
        this.repo = repo;
    }

    @RequestMapping("/")
    public String home(@RequestParam(required = false, name = "token") String newToken) {
        String newUserName = Authenticated.getUsername();
        token = newToken;
        System.out.println("Token: " + token);

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
    public String login(@RequestParam(required = false, name = "token") String newToken) {
        String newUserName = Authenticated.getUsername();
        token = newToken;
        System.out.println("Token: " + token);

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
    public String loggedin(@RequestParam(required = false, name = "token") String newToken) {
        String newUserName = Authenticated.getUsername();
        token = newToken;
        System.out.println("Token: " + token);

        if(!newUserName.equals("anonymousUser")) {
            foundUser = repo.findByUserName(newUserName)
                .orElseThrow(() -> new UserNotFoundException(newUserName));
            loggedIn = Authenticated.isAuth();  //Get rid of this line and just put true in next line
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
    public @ResponseBody String getAuth(@RequestParam(required = false) String user) {

        boolean userNameExists = repo.existsByUserName(user);

        if (token != null)
            return "true";
        else if (userNameExists) {
            User foundUser = repo.findByUserName(user)
                    .orElseThrow(() -> new UserNotFoundException(user));
            return String.valueOf(foundUser.isLoggedIn());
        } else
            return "false";
    }
}
