package com.demo.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.entity.Student;
import com.demo.entity.Subject;

@Repository
public class StudentAndSubjectDaoImplementation implements StudentAndSubjectDao {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean saveStudent(Student std) {

		boolean result = false;
		try {

			Session session = sessionfactory.openSession();
			Transaction txn = session.beginTransaction();

			session.save(std);

			txn.commit();
			session.close();
			result = true;
		} catch (Exception e) {

			System.out.println("Error occurred while storing the student : " + e.getMessage());
		}

		return result;

	}

	@Override
	public List<Student> getStudents() {

		List<Student> listStd = null;

		try {

			Session session = sessionfactory.openSession();
			Transaction txn = session.beginTransaction();

			Query<Student> query = session.createQuery("from Student");
			listStd = query.getResultList();

			txn.commit();
			session.close();

		} catch (HibernateException e) {

			System.out.println("Exception: " + e.getMessage());

		} finally {

			return listStd;
		}

	}

	@Override
	public Student getstudent(int id) {

		Student std = null;

		Session session = sessionfactory.openSession();
		Transaction txn = session.beginTransaction();

		std = session.get(Student.class, id);

		txn.commit();
		session.close();

		return std;

	}

	@Override
	public List<Subject> getsubjects() {

		List<Subject> sublist = null;

		try {

			Session session = sessionfactory.openSession();
			Transaction txn = session.beginTransaction();

			Query<Subject> query = session.createQuery("from Subject");
			sublist = query.getResultList();

			txn.commit();
			session.close();

		} catch (HibernateException e) {

			System.out.println("Exception: " + e.getMessage());

		} finally {

			return sublist;
		}
	}

	@Override
	public Subject getsub(int id) {

		Subject sub = null;

		Session session = sessionfactory.openSession();
		Transaction txn = session.beginTransaction();

		sub = session.get(Subject.class, id);

		txn.commit();
		session.close();

		return sub;

	}

}
