package com.lms.demo.service;

import com.lms.demo.dao.studentsRepository;
import com.lms.demo.entity.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServicesImpl implements StudentServices{
    public studentsRepository StudentsRepository;
    @Autowired
    public StudentServicesImpl(studentsRepository theStudentsRepository) {
        StudentsRepository = theStudentsRepository;
    }

    @Override
    public List<student> showAllStudents() {
        return StudentsRepository.findAll();
    }

    @Override
    public student findByStudentId(int theId) {
        Optional<student> result = StudentsRepository.findByStudentId(theId);
        System.out.println(result.toString());
        student theStudent = null;

        if (result.isPresent()) {
            theStudent = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theStudent;
    }

    @Override
    public List<student> showSelectedStudents(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the username of the logged-in user
        String loggedInUsername = authentication.getName();
        return StudentsRepository.findByStudentName(loggedInUsername);
    }
}
