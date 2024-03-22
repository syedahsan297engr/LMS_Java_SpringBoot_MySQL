package com.lms.demo.controller;

import com.lms.demo.dao.coursesRepository;
import com.lms.demo.dao.studentsRepository;
import com.lms.demo.entity.courses;
import com.lms.demo.entity.student;
import com.lms.demo.service.StudentServices;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class InstructorController {
    public studentsRepository StudentsRepository;
    public StudentServices studentServices;
    public coursesRepository CoursesRepository;

    public InstructorController(studentsRepository studentsRepository, coursesRepository coursesRepository, StudentServices thestudentServices) {
        StudentsRepository = studentsRepository;
        CoursesRepository = coursesRepository;
        studentServices = thestudentServices;
    }

    @GetMapping("/systems")
    public String showSystems(Model theModel) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the username of the logged-in user
        String loggedInUsername = authentication.getName();
        //System.out.println(loggedInUsername);
        //get courses of instructor
        List<student> theInstructorCourses = StudentsRepository.findByInstructorName(loggedInUsername);
        //System.out.println(theStudents);

        // add to the spring model
        theModel.addAttribute("admin", theInstructorCourses);
        return "systems";
    }

    @GetMapping("/updateGrades")
    public String updateGrades(Model theModel) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the username of the logged-in user
        String loggedInUsername = authentication.getName();
        //System.out.println(loggedInUsername);
        //get courses of instructor
        List<student> theInstructorCourses = StudentsRepository.findByInstructorName(loggedInUsername);
        //System.out.println(theStudents);

        // add to the spring model
        theModel.addAttribute("admin", theInstructorCourses);
        return "updateGrades";
    }

    @GetMapping("/offerCourse")
    public String offerCourse(Model theModel) {
        courses theCourse = new courses();
        theModel.addAttribute("courses", theCourse);
        return "offerCourse";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") courses theCourse) {

        // save the employee
        CoursesRepository.save(theCourse);

        // use a redirect to prevent duplicate submissions
        return "redirect:/admin/systems";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int theId,
                                    Model theModel) {

        // get the employee from the service
        student theStudent = studentServices.findByStudentId(theId);
        //System.out.println(theStudent.getStudentId());
        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("student", theStudent);

        // send over to our form
        return "showFormForUpdate";
    }

    @PostMapping("/saveGrade")
    public String saveStudent(@ModelAttribute("student") student theStudent) {

        // Retrieve the student from the database using its ID
        int theId = StudentServices.getTheStudentId(theStudent);
        //System.out.println(theId);
        student existingStudent = studentServices.findByStudentId(theId);

        // Update the grade
        existingStudent.setGrade(theStudent.getGrade());

        // Save the updated student record
        StudentsRepository.save(existingStudent);

        // use a redirect to prevent duplicate submissions
        return "redirect:/admin/updateGrades";
    }
}
