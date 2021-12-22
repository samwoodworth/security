package com.springboot.security.config;

import com.springboot.security.model.User;
import com.springboot.security.repo.UserRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepo repository) {
  
      return args -> {
        log.info("Preloading " + repository.save(new User("user", "pass", true, "USER", false)));
        log.info("Preloading " + repository.save(new User("admin", "pass", true, "ADMIN", false)));
      };
    }
}
