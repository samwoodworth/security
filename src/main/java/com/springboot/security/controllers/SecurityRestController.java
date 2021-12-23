package com.springboot.security.controllers;

import com.springboot.security.repo.UserRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityRestController {

    private final UserRepo repo;

    SecurityRestController(UserRepo repo) { this.repo = repo; }

    @GetMapping("/get_auth")
    boolean get_auth(@PathVariable )
        User foundUser = repo.

}
