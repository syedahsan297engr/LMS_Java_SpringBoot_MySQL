package com.lms.demo.dao;

import com.lms.demo.entity.grades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface gradesRepository extends JpaRepository<grades, Integer> {

}
