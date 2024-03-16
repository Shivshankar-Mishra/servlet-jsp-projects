package com.jsp.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.hibernate.dto.Product;
import com.mysql.cj.Query;

public class ProductDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
//	Product p = new Product();
	
	public Product saveProductDao(Product p) {
		entityTransaction.begin();
		entityManager.persist(p);
		entityTransaction.commit();
		
		return p; 
	}
	public Product fetchOne(int id) {
		entityTransaction.begin();
		Product p = entityManager.find(Product.class, id);
		entityTransaction.commit();
		return p;
	}
	public boolean delete(int id) {
		Product p = fetchOne(id);
		if(p!=null) {
		entityTransaction.begin();
		entityManager.remove(p);
		entityTransaction.commit();
		return true;
		}else {
		return false;
		}
	}
	public Product updateByName(int id, String name) {
		Product p = fetchOne(id);
		p.setName(name);
		entityTransaction.begin();
		entityManager.merge(p);
		entityTransaction.commit();
		return p;
	}
	public List<Product> fetchAll(){

		String fetchQuery = "From Product";
		javax.persistence.Query query = entityManager.createQuery(fetchQuery);
		return query.getResultList();
		
	}
	public void multiInsert(List<Product> products) {
		entityTransaction.begin();
		for(Product p: products) {
			entityManager.persist(p);
		}
		entityTransaction.commit();
	}
	public List<Product> fetchByColor(String color){
		List<Product> products = fetchAll();
		List<Product> productWithColor = new ArrayList<Product>();
		for(Product p: products) {
			if(p.getColor().equals(color)) {
				productWithColor.add(p);
			}
		}
		return productWithColor;		
	}

}
