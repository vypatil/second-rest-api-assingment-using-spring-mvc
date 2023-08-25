package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.StudentAndSubjectDao;
import com.demo.entity.Student;
import com.demo.entity.Subject;

@Service
public class StudentAndSubjectServiceImplementation implements StudentAndSubjectService {

	@Autowired
	StudentAndSubjectDao studentAndsubjectDao;

	@Override
	public boolean saveStudent(Student std) {
		return studentAndsubjectDao.saveStudent(std);

	}

	@Override
	public List<Student> getStudents() {

		return studentAndsubjectDao.getStudents();

	}

	@Override
	public Student getstudent(int id) {
		return studentAndsubjectDao.getstudent(id);
	}

	@Override
	public List<Subject> getsubjects() {
		return studentAndsubjectDao.getsubjects();
	}

	@Override
	public Subject getsub(int id) {
		return studentAndsubjectDao.getsub(id);
	}

	@Override
	public List<Subject> getSubjectListById(int id) {
		return studentAndsubjectDao.getSubjectListById(id);
	}

	@Override
	public List<Student> getStudents(Integer firstResult, Integer maxResult) {
		
		return studentAndsubjectDao.getStudents(firstResult , maxResult);
	}

}
