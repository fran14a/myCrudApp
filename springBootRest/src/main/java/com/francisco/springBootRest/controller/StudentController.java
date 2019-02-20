//Controller will access to DAO
package com.francisco.springBootRest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.springBootRest.dao.StudentDao;
import com.francisco.springBootRest.model.Student;

@RestController
@RequestMapping("/school/")
public class StudentController {
	
	@Autowired
	StudentDao studentDao;// DAO object
	
	//CREATE using mapping
	@PostMapping("/students")
	public Student createStudent(@Valid @RequestBody Student student) {
		return studentDao.save(student);
	}
	
	//READ all
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentDao.findAll();
	}
	
	//Read by id
	@GetMapping("/notes/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value="id") Long studentId) {
		
		Student student = studentDao.findOne(studentId);
		
		if(student == null) {
			return ResponseEntity.notFound().build(); //if the id was not found
		}
		return ResponseEntity.ok().body(student);
	}
	
	//UPDATE by id
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value="id") Long studentId, 
			@Valid @RequestBody Student stuDetails) {
		
		Student student = studentDao.findOne(studentId); 
	
		if(student == null) {
			return ResponseEntity.notFound().build(); //if the id was not found
		}
		
		student.setName(stuDetails.getName());
		student.setSpeciality(stuDetails.getSpeciality());
		student.setSkills(stuDetails.getSkills());
		
		Student updateStudent = studentDao.save(student);
		
		return ResponseEntity.ok().body(updateStudent);
		
	}
	
	//DELETE
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable(value="id") Long studentId) {
		
		Student student = studentDao.findOne(studentId); 
		
		if(student == null) {
			return ResponseEntity.notFound().build(); //if the id was not found
		}
		
		studentDao.delete(student);
		
		return ResponseEntity.ok().build();
		
	}
	

}
