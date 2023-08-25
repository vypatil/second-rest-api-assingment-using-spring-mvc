package com.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Student;
import com.demo.entity.Subject;
import com.demo.service.StudentAndSubjectService;
import com.demo.service.StudentAndSubjectServiceImplementation;
import com.demo.util.StudentNameComparator;

@RestController
public class StudentAndSubjectController {

	@Autowired
	StudentAndSubjectService studentAndSubjectService;

	@PostMapping("/students")
	public String saveStudent(@RequestBody Student std) {

		System.out.println("request received to create student " + std);

		if (studentAndSubjectService.saveStudent(std))
			return "Student saved succesfully";

		else

			return "Student not saved!!!";

	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> response = studentAndSubjectService.getStudents();
		System.out.println("list returned>>>>>>>>>>>>" + response);

		return response;

	}

	@GetMapping("/students/{id}")
	public Student geStudent(@PathVariable int id) {

		System.out.println("request received to get student of id : " + id);

		Student retrivedStudent = studentAndSubjectService.getstudent(id);

		return retrivedStudent;

	}

	@GetMapping("/subjects")
	public List<Subject> geSubjects() {

		return studentAndSubjectService.getsubjects();

	}

	@GetMapping("/students/{id}/subjects/{id}")
	public Subject getsub(@PathVariable int id) {

		return studentAndSubjectService.getsub(id);

	}

	@GetMapping("/students/{id}/subjects")
	public List<Subject> getSubjectListById(@PathVariable int id) {

		return studentAndSubjectService.getSubjectListById(id);

	}

	@GetMapping("/students/sortByName")		// sorting students
	public List<Student> getAllStudentsByName() {

		List<Student> stdList = studentAndSubjectService.getStudents();

		Collections.sort(stdList, new StudentNameComparator());

		return stdList;
	}

	@GetMapping("/student")			// pagination
	public List<Student> getAllStudents(@RequestParam(required = false) Integer firstResult,
			@RequestParam(required = false) Integer maxResult) {

		System.out.println("request recived to get all students");

		if ((firstResult != null) && (maxResult != null))

			return studentAndSubjectService.getStudents(firstResult, maxResult);

		else
			return studentAndSubjectService.getStudents();

	}

}
