package com.lms.demo.controller;

import com.lms.demo.dao.studentsRepository;
import com.lms.demo.entity.student;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/parents")
public class ParentController {
    public studentsRepository StudentsRepository;

    public ParentController(studentsRepository studentsRepository) {
        StudentsRepository = studentsRepository;
    }
    @GetMapping("/leaders")
    public String showLeaders(Model theModel) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the username of the logged-in user
        String loggedInUsername = authentication.getName();
        //System.out.println(loggedInUsername);
        //get courses of instructor
        List<student> theSonGrades = StudentsRepository.findByParentName(loggedInUsername);
        //System.out.println(theStudents);

        // add to the spring model
        theModel.addAttribute("parents", theSonGrades);
        return "leaders";
    }
}
