package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Student;
import com.demo.entity.Subject;
import com.demo.service.StudentAndSubjectService;
import com.demo.service.StudentAndSubjectServiceImplementation;

@RestController
public class StudentAndSubjectController {
	
	@Autowired
	StudentAndSubjectService studentAndSubjectService;
		
	@PostMapping("/students")
	public String saveStudent(@RequestBody Student std) {

		System.out.println("request received to create student " +std);
		
		if(studentAndSubjectService.saveStudent(std))
			return "Student saved succesfully";
		
		else 
			
		return	"Student not saved!!!";
		
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return	studentAndSubjectService.getStudents();
		
	}
	
	@GetMapping("/students/{id}")
	public Student geStudent(@PathVariable int id) {
		
		System.out.println("request received to get student of id : " + id);

		Student retrivedStudent = studentAndSubjectService.getstudent(id);

		return retrivedStudent;
		
	}
	
	@GetMapping("/subjects")
	public List<Subject> geSubjects(){
		
		return studentAndSubjectService.getsubjects();
		
	}
	
	@GetMapping("/students/{id}/subjects/{id}")
	public Subject getsub(@PathVariable int id) {
		
		return studentAndSubjectService.getsub(id);
		
	}
	
	@GetMapping("/students/{id}/subjects")
	public List<Subject> getSubjectListById( @PathVariable int id){
		
		return studentAndSubjectService.getSubjectListById(id);
		
		
	} 
	
	
	
	

}
