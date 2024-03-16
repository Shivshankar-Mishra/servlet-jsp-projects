package com.jsp.one_to_one_uni.dao;
/**
 * @author Shivshankar Mishra
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.one_to_one_uni.dto.Adhar;
import com.jsp.one_to_one_uni.dto.Person;

public class PersonOneToOneDao {
	/**
	 * Below code is for establishing the connection with database and perform crud operation on the basis of methods 
	 */
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	/**
	 * method for inserting data into database
	 * @param p
	 * @return Person p;
	 */
	public Person insert(Person p, Adhar a) {
		entityTransaction.begin();
		entityManager.persist(p);
		entityManager.persist(a);
		entityTransaction.commit();
		System.out.println("Data Stored successfully!!!");
		return p;
	}
	/**
	 * method for fetching one person data
	 * @param id
	 * @return Person;
	 */
	public Person fetch(int id) {
		return entityManager.find(Person.class, id);
	}
}
