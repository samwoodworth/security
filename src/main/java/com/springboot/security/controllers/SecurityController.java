package com.springboot.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
class SecurityController {

    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping("/home")
    public ModelAndView loggedin() {
        return new ModelAndView("loggedin");
    }
}
