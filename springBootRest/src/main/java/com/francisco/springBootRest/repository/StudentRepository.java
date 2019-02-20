package com.francisco.springBootRest.repository;

import com.francisco.springBootRest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}