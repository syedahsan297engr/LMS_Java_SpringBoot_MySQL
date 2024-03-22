package com.lms.demo.controller;

import com.lms.demo.dao.coursesRepository;
import com.lms.demo.dao.studentsRepository;
import com.lms.demo.entity.courses;
import com.lms.demo.entity.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    public studentsRepository StudentsRepository;
    public coursesRepository CoursesRepository;
    @Autowired
    public StudentController(studentsRepository theStudentsRepository, coursesRepository theCoursesRepository) {
        StudentsRepository = theStudentsRepository;
        CoursesRepository = theCoursesRepository;
    }


    @GetMapping("/viewCourses")
    public String viewCourses(Model theModel) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the username of the logged-in user
        String loggedInUsername = authentication.getName();
        //System.out.println(loggedInUsername);
        List<student> theStudents = StudentsRepository.findByStudentName(loggedInUsername);
        //System.out.println(theStudents);

        // add to the spring model
        theModel.addAttribute("student", theStudents);
        return "viewCourses";
    }

    @GetMapping("/registerCourses")
    public String registerCourses(Model theModel) {
        List<courses> theCourses = CoursesRepository.findAll();
        theModel.addAttribute("courses", theCourses);
        return "registerCourses";
    }

    @GetMapping("/customQueryResult")
    public String customQueryResult(Model theModel) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the username of the logged-in user
        String loggedInUsername = authentication.getName();
        //System.out.println(loggedInUsername);
        List<student> theStudents = StudentsRepository.findByStudentName(loggedInUsername);
        //System.out.println(theStudents);

        // add to the spring model
        theModel.addAttribute("student", theStudents); //student is the table name in db
        return "customQueryResult";
    }
}
