package com.jsp.hibernate.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate.dto.Product;
import com.jsp.hibernate.service.ProductService;

public class ProductController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Product p = null;
		ProductService ps = new ProductService();
		while(true) {
			System.out.println("1. Insert");
			System.out.println("2. Delete");
			System.out.println("3. Update Name");
			System.out.println("4. Display Data By id");
			System.out.println("5. Display All Data");
			System.out.println("6. Insert multiple Data");
			System.out.println("7. Fetch Data by Color");
			System.out.println("Enter your option: ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				p = new Product();
				System.out.println("Enter Id: ");
				int id = sc.nextInt();
				System.out.println("Enter name: ");
				String name = sc.next();
				System.out.println("Enter color:");
				String color = sc.next();
				System.out.println("Enter price: ");
				double price = sc.nextDouble();
				p.setId(id);
				p.setName(name);
				p.setColor(color);
				p.setPrice(price);
				ps.saveProductService(p);
				break;
			case 2:
				System.out.println("Enter id: ");
				int id2 = sc.nextInt();
				if(ps.deleteData(id2)) {
					System.out.println("Data deleted....");
				};
				break;
			case 3:
				System.out.println("Enter id: ");
				int id3 = sc.nextInt();
				System.out.println("Enter name: ");
				String name1 = sc.next();
				Product p1 = ps.updateDataByName(id3, name1);
				if(p1!=null) {
					System.out.println("Data updated");
					System.out.println(p);
				}else {
					System.out.println("Something bad happened. Please try again");
				}
				break;
			case 4:
				System.out.println("Enter id: ");
				int id1 = sc.nextInt();
				p = new Product();
				p = ps.fetchOneData(id1);
				System.out.println(p);
				break;
			case 5:
				List<Product> p3 = ps.fetchAllData();
				for(Product p2: p3) {
					System.out.println(p2);
				}
				break;
			case 6:
				System.out.println("You want to insert multiple data at a time");
				System.out.println("Please enter how many data you want to enter: ");
				int nData = sc.nextInt();
				List<Product> products = new ArrayList<Product>();
				for(int i=0; i<nData; i++) {
					p = new Product();
					System.out.println("Enter the id: ");
					p.setId(sc.nextInt());
					System.out.println("Enter the name: ");
					sc.nextLine();
					p.setName(sc.nextLine());
					System.out.println("Enter the color: ");
					p.setColor(sc.next());
					System.out.println("Enter the price: ");
					p.setPrice(sc.nextDouble());
					products.add(p);
					System.out.println("==================");
					System.out.println(p);
					System.out.println("Enter next product details: ");
				}
				ps.multiInsertData(products);
				System.out.println(nData+" Data Inserted into database");
				break;
			case 7:
				System.out.println("Please enter the color: ");
				String colorName = sc.next();
				List<Product> product = ps.fetchByColorName(colorName);
				for(Product p5: product) {
					System.out.println(p5);
				}
				break;
			}
				
			
		}
	}

}
