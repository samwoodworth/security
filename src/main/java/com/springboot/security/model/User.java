package com.springboot.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    
    @Id
    private String userName;
    private String password;
    private boolean active;
    private String roles;
    private boolean loggedIn;

    public User() {}

    public User(String userName, String password, boolean active, String roles, boolean loggedIn) {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.loggedIn = loggedIn;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public String getRoles() {
        return roles;
    }
    public void setRoles(String roles) {
        this.roles = roles;
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public String toString() {
        return "User [active=" + active + ", loggedIn=" + loggedIn + ", password=" + password + ", roles=" + roles
                + ", userName=" + userName + "]";
    }
}
