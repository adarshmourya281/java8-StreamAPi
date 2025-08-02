package com.am.streams;

public class MarketPlaceTest 
{
	public static void main(String[] args) 
	{
		Marketplace mp = new Marketplace();
		
		mp.addProduct("111", "Mobile", 82000.0, 2);
		mp.addProduct("222", "Laptop", 55000.0, 1);
		
		mp.getProductsInStock();
		
		mp.addToWishlist("999", "111");
		mp.addToWishlist("888", "222");
		
		mp.getWishlistByCustomer("999");
		
		mp.removeFromWishlist("888", "222");
		
		mp.searchProductsByName("Mobile");
	}
}
