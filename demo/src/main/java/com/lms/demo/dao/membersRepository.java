package com.lms.demo.dao;

import com.lms.demo.entity.members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface membersRepository extends JpaRepository<members, Integer> {

}
