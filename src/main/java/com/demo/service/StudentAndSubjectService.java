package com.demo.service;

import java.util.List;

import com.demo.entity.Student;
import com.demo.entity.Subject;


public interface StudentAndSubjectService {
	
	public boolean saveStudent(Student std);
	
	public List<Student> getStudents();
	
	public Student getstudent(int id);
	
	public List<Subject> getsubjects();

	public Subject getsub(int id);

	public List<Subject> getSubjectListById(int id);

}
