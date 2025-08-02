package com.am.streams;

import java.util.HashSet;
import java.util.Set;

import com.akshu.methods_collection.Product;

public class RetriveOnlySpecificClassObjectsFromCollections {

	public static void main(String[] args) 
	{
		Set<Object> productCatalog = new HashSet<>();
		
		productCatalog.add(new Product(1, null, 0));
		productCatalog.add(new Product(2, null, 0));
		productCatalog.add(new Product(3, null, 0));
		
		productCatalog.add(new Student(null, null));
		
		System.out.println("Using getClass() method...");
	    productCatalog.stream().filter( e -> e.getClass().equals(new Product(4, null, 0).getClass())).forEach(System.out :: println);
		
		System.out.println("Using Instaceof oprator ...........");
		
		productCatalog.stream().filter( e -> (e instanceof Product)).forEach(System.out :: println);
			
	}

}
