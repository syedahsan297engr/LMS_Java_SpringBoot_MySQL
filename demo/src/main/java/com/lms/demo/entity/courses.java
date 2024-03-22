package com.lms.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name")
    private String courseName;
    @Column(name = "instructor_name")
    private String instructorName;

    @Column(name = "mail")
    private String mail;

    public courses() {
    }

    public courses(int courseId, String courseName, String instructorName, String mail) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructorName = instructorName;
        this.mail = mail;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
