package com.lms.demo.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "parents")
public class parents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id")
    private int parentId;

    @Column(name = "parent_name")
    private String parentName;

    // Constructors, Getters, Setters, and toString method

    public parents(int parentId, String parentName) {
        this.parentId = parentId;
        this.parentName = parentName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return "parents{" +
                "parentId=" + parentId +
                ", parentName='" + parentName + '\'' +
                '}';
    }
}

