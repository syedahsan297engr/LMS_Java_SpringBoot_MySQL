package com.lms.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructors")
public class instructors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id")
    private int instructorId;

    @Column(name = "instructor_name")
    private String instructorName;

    // Constructors, Getters, Setters, and toString method

    public instructors() {
    }

    public instructors(int instructorId, String instructorName) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    @Override
    public String toString() {
        return "instructors{" +
                "instructorId=" + instructorId +
                ", instructorName='" + instructorName + '\'' +
                '}';
    }
}
