package com.jsp.one_to_many_many.dao;
/**
 * @author Shivshankar Mishra
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.one_to_many_many.dto.Student;
import com.jsp.one_to_many_many.dto.Teacher;
import com.mysql.cj.Query;

public class TeacherStudentDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Teacher insert(Teacher t) {
		entityTransaction.begin();
		entityManager.persist(t);
		for(Student st: t.getStudent()) {
			entityManager.persist(st);
		}
		entityTransaction.commit();
		return t;
	}
	public List<Teacher> fetchAll(){
		String fetchQuery = "From Teacher";
		javax.persistence.Query query = entityManager.createQuery(fetchQuery);
		return query.getResultList();
	}
	public Teacher fetchOne(int id) {
		entityTransaction.begin();
		 Teacher t = entityManager.find(Teacher.class, id);
		entityTransaction.commit();
		return t;
	}
	public Teacher updateTeacher(Teacher t) {
		entityTransaction.begin();
		entityManager.merge(t);
		entityTransaction.commit();
		return t;
		
	}
	public void deleteTeacher(int id) {
		Teacher t = fetchOne(id);
		entityTransaction.begin();
		entityManager.remove(t);
		entityTransaction.commit();
	}
	public Student fetchStudent(int tid, int sid) {
		Teacher t = fetchOne(tid);
//		entityTransaction.begin();
		for(Student st : t.getStudent()) {
			if(sid == st.getId()) {
				return st;
			}
		}
		return null;
	}
	public void deleteStudent(int tid, int sid) {
		Student st = fetchStudent(tid, sid);
		entityTransaction.begin();
		entityManager.remove(st);
		entityTransaction.commit();
	}
	
}
