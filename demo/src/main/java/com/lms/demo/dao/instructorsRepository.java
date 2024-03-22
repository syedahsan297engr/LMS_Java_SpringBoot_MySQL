package com.lms.demo.dao;

import com.lms.demo.entity.instructors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface instructorsRepository extends JpaRepository<instructors, Integer> {

}
