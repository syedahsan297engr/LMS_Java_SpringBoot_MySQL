package com.lms.demo.dao;

import com.lms.demo.entity.courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface coursesRepository extends JpaRepository<courses, Integer> {

}
