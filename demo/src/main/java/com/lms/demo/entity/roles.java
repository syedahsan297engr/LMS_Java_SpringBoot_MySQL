package com.lms.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private members member;

    @Column(name = "role")
    private String role;

    // Constructors, Getters, Setters, and toString method

    public roles(int id, members member, String role) {
        this.id = id;
        this.member = member;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public members getMember() {
        return member;
    }

    public void setMember(members member) {
        this.member = member;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "roles{" +
                "id=" + id +
                ", member=" + member +
                ", role='" + role + '\'' +
                '}';
    }
}
