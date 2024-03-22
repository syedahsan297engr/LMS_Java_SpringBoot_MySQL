package com.lms.demo.service;

import com.lms.demo.entity.student;

import java.util.List;

public interface StudentServices {

    List<student> showAllStudents();
    student findByStudentId(int theId);
    List<student> showSelectedStudents();

    static int getTheStudentId(student Student){
        return Student.getStudentId();
    }
}
