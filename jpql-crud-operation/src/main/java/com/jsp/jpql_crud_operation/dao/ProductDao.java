package com.jsp.jpql_crud_operation.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.jpql_crud_operation.dto.Product;

public class ProductDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate_jpql");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	public Product insertProduct(Product p) {
		String query = "INSERT INTO product(id, name, color, price) values(?,?,?,?)";
		Query q = entityManager.createNativeQuery(query);
		q.setParameter(1, p.getId());
		q.setParameter(2, p.getName());
		q.setParameter(3, p.getColor());
		q.setParameter(4, p.getPrice());
		entityTransaction.begin();
		int a = q.executeUpdate();
		entityTransaction.commit();
		System.out.println(a);
		return p;
	}
	public Product fetchOne(int id) {
//		use placeholder values:
//			use : for named position i.e- :abc
//			use ? for number position i.e- ?1
		String query = "SELECT p FROM Product p WHERE p.id=?1";
		Query q = entityManager.createQuery(query);
		q.setParameter(1, id);
		Object object = q.getSingleResult();
		return (Product)object;
	}
	public void deleteProduct(int id) {
		String query = "DELETE FROM Product p WHERE P.ID =?123";
		Query q = entityManager.createQuery(query);
		q.setParameter(123, id);
		entityTransaction.begin();
		int a = q.executeUpdate();
		entityTransaction.commit();
		
		if(a==1) {
			System.out.println(a);
		}
	}

}
