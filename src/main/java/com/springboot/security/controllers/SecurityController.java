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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
class SecurityController {

    @Autowired
    UserRepo repo;
    boolean loggedIn = false;
    String token;

    //Creates extra, null user in db
    //@Autowired
    User foundUser = new User();

    SecurityController(UserRepo repo) {
        this.repo = repo;
    }

    @RequestMapping("/")
    public ModelAndView home(@RequestParam(required = false, name = "token") String newToken) {
        String newUserName = Authenticated.getUsername();
        token = newToken;

        if(!newUserName.equals("anonymousUser")) {
            foundUser = repo.findByUserName(newUserName)
                .orElseThrow(() -> new UserNotFoundException(newUserName));
            loggedIn = Authenticated.isAuth();
            foundUser.setLoggedIn(loggedIn);
        } else
            foundUser.setLoggedIn(false);

        repo.save(foundUser);
        return new ModelAndView("home");
    }

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam(required = false, name = "token") String newToken) {
        String newUserName = Authenticated.getUsername();
        token = newToken;

        if(!newUserName.equals("anonymousUser")) {
            foundUser = repo.findByUserName(newUserName)
                    .orElseThrow(() -> new UserNotFoundException(newUserName));
            loggedIn = Authenticated.isAuth();
            foundUser.setLoggedIn(loggedIn);
        } else
            foundUser.setLoggedIn(false);
        
        repo.save(foundUser);
        return new ModelAndView("login");
    }

    @RequestMapping("/home")
    public ModelAndView loggedin(@RequestParam(required = false, name = "token") String newToken) {
        String newUserName = Authenticated.getUsername();
        token = newToken;

        if(!newUserName.equals("anonymousUser")) {
            foundUser = repo.findByUserName(newUserName)
                .orElseThrow(() -> new UserNotFoundException(newUserName));
            loggedIn = Authenticated.isAuth();
            foundUser.setLoggedIn(loggedIn);
        } else
            foundUser.setLoggedIn(false);

        repo.save(foundUser);
        return new ModelAndView("loggedin");
    }

    @GetMapping("/getAuth")
    @ResponseBody
    public String getAuth(HttpServletResponse response) {

        if (token != null)
            return "true";
        else if (loggedIn) {
            Cookie username = new Cookie("username", foundUser.getUserName()); //Add class variable to login and/or loggedin to assign and add here
            response.addCookie(username);
            return "true";
        } else
            return "false";
    }
}
