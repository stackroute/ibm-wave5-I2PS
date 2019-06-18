package com.stackroute.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class User {
    public User() {
    }

    public User(int userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    @Id
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;


}