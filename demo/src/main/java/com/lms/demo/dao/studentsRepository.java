package com.lms.demo.dao;

import com.lms.demo.entity.student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface studentsRepository extends JpaRepository<student, Integer> {

    List<student> findByStudentName(String studentName);

    List<student> findByInstructorName(String loggedInUsername);

    List<student> findByParentName(String loggedInUsername);

    Optional<student> findByStudentId(int theId);
}
