package com.demo.util;

import java.util.Comparator;

import com.demo.entity.Student;

public class StudentNameComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		
		return s1.getName().compareTo(s2.getName());
	}

}
