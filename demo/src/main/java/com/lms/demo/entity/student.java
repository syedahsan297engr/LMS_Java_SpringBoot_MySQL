package com.lms.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "parent_name")
    private String parentName;

    @Column(name = "instructor_name")
    private String instructorName;

    @Column(name = "grade")
    private String grade;

    @Column(name = "parent_id")
    private int parentId;

    @Column(name = "instructor_id")
    private int instructorId;

    // Constructors, Getters, and Setters

    public student(int studentId) {
        this.studentId = studentId;
    }

    public student(String studentName, String courseName, String grade) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.grade = grade;
    }

    public student() {
    }

    public student(String studentName, String courseName, String parentName, String instructorName, String grade, int parentId, int instructorId) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.parentName = parentName;
        this.instructorName = instructorName;
        this.grade = grade;
        this.parentId = parentId;
        this.instructorId = instructorId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    @Override
    public String toString() {
        return "student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", parentName='" + parentName + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", grade='" + grade + '\'' +
                ", parentId=" + parentId +
                ", instructorId=" + instructorId +
                '}';
    }
}
