package com.lms.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "members")
public class members {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "pw")
    private String password;

    @Column(name = "active")
    private boolean active;

    // Constructors, Getters, Setters, and toString method

    public members(String userId, String password, boolean active) {
        this.userId = userId;
        this.password = password;
        this.active = active;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "members{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}

