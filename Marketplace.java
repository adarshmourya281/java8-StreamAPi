package com.akshu.streams;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
	
public class Marketplace 
{
	Set<Products> productCatalog = new HashSet<>();
	
	static Integer orderId = 1;
	
	Map<Integer , String> orderHistory = new HashMap<>();
	
	Map<String , String> customerWishlist = new HashMap<>();
	
	public void addProduct(String productID, String productName, double price, int quantityInStock)
	{
		Products p = new Products(productID, productName, price, quantityInStock);
		productCatalog.add(p);
		System.out.println("product added successfully.....");
	}
	
	public void removeProduct(String productID)
	{
		productCatalog.remove(productID);
		System.out.println("product removed......");
	}
	
	public void addToWishlist(String customerID, String productID)
	{
		customerWishlist.put(customerID, productID);
		System.out.println("Product added in wishList.......");
	}
	
	public void placeOrder(String customerID, String productIDs)
	{
		orderHistory.put(orderId, customerID.concat(" : "+productIDs));
		System.out.println("Order placed and OrderId : "+orderId++);
		//productCatalog.stream().filter( t -> t.getProductID().equalsIgnoreCase(customerID))
	}
	
	public void removeFromWishlist(String customerID, String productID)
	{
		customerWishlist.remove(customerID);
		System.out.println("Product removed from wishList ....");
	}
	
	public void getProductsInStock()
	{
		System.out.println("Products available are: ");
		productCatalog.stream().filter(p -> p.getQuantityInStock() > 0).forEach(System.out :: println);
	}
	
	public void getWishlistByCustomer(String customerID)
	{
		System.out.println("Product in wishList are : ");
		System.out.println(customerWishlist.get(customerID));
	}
	
	public void searchProductsByName(String keyword)
	{
		System.out.println("Product avilable are: ");
		productCatalog.stream().filter(p -> p.getProductName().equalsIgnoreCase(keyword)).forEach(System.out :: println);
	}
	
}
