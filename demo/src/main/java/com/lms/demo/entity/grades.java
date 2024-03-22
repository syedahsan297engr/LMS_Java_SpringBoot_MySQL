package com.lms.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "grades")
public class grades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private int gradeId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private courses course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private student student;

    @Column(name = "grade")
    private String grade;

    // Constructors, Getters, Setters, and toString method

    public grades(int gradeId, courses course, student student, String grade) {
        this.gradeId = gradeId;
        this.course = course;
        this.student = student;
        this.grade = grade;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public courses getCourse() {
        return course;
    }

    public void setCourse(courses course) {
        this.course = course;
    }

    public student getStudent() {
        return student;
    }

    public void setStudent(student student) {
        this.student = student;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "grades{" +
                "gradeId=" + gradeId +
                ", course=" + course +
                ", student=" + student +
                ", grade='" + grade + '\'' +
                '}';
    }
}
