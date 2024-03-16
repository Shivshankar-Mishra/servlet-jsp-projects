package com.jsp.jpql_crud_operation.controller;

import com.jsp.jpql_crud_operation.service.ProductService;

public class ProductController {
	
	public static void main(String[] args) {
		ProductService ps = new ProductService();
		Scanner sc = 
		char c;
		do {
			System.out.println("1. Insert Product");
			System.out.println("2. Fetch Product by Id");
			System.out.println("3. Delete Product");
			System.out.println("4. Update Product");
			System.out.println("Select your option: ");
			
			switch() {}
		}while(c=='y'||c=='Y');
	}

}
