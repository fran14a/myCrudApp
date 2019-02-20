package com.francisco.springBootRest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.springBootRest.model.Student;
import com.francisco.springBootRest.repository.StudentRepository;

@Service // SpringBoot will ask for this annotation
//in this class we use the repository
public class StudentDao { //Data Access Object

	@Autowired
	StudentRepository studentRepository;
	
	// --- 4 methods CRUD --- CREATE, READ, UPDATE, DELETE
	
	//CREATE
	public Student save(Student student) {
		return studentRepository.save(student);
	}
	
	//READ - search all students
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	//UPDATE by id
	public Student findOne(Long studId) {
		return studentRepository.getOne(studId);
	}
	
	//DELETE
	public void delete(Student student) {
		studentRepository.delete(student);
	}
	
}
