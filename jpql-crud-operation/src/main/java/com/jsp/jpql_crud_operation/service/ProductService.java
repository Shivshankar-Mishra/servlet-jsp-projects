package com.jsp.jpql_crud_operation.service;

import com.jsp.jpql_crud_operation.dao.ProductDao;
import com.jsp.jpql_crud_operation.dto.Product;

public class ProductService {
	ProductDao pd = new ProductDao();
	public Product insertProductData(Product p) {
		return pd.insertProduct(p);
	}
	public Product fetchOneData(int id) {
		return pd.fetchOne(id);
	}

}
