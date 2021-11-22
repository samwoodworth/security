package com.springboot.security.repo;

import java.util.Optional;

import com.springboot.security.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findByUserName(String userName);
}
