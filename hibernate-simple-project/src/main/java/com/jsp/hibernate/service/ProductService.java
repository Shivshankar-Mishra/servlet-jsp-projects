package com.jsp.hibernate.service;

import java.util.List;

import com.jsp.hibernate.dao.ProductDao;
import com.jsp.hibernate.dto.Product;

public class ProductService {
	ProductDao pd = new ProductDao();
	public Product saveProductService(Product p) {
		return pd.saveProductDao(p);
	}
	public Product fetchOneData(int id) {
		return pd.fetchOne(id);
	}
	public boolean deleteData(int id) {
		return pd.delete(id);
	}
	public Product updateDataByName(int id, String name) {
		return pd.updateByName(id, name);
	}
	public List<Product> fetchAllData(){
		return pd.fetchAll();
	}
	public void multiInsertData(List<Product> products) {
		pd.multiInsert(products);
	}
	public List<Product> fetchByColorName(String color){
		return pd.fetchByColor(color);
	}

}
