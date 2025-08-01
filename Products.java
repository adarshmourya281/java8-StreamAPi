package com.akshu.streams;

public class Products 
{
		private String productID ;
		private String productName ;
		private Double price ;
		private int quantityInStock ;
		
		public String getProductID() {
			return productID;
		}

		public void setProductID(String productID) {
			this.productID = productID;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public int getQuantityInStock() {
			return quantityInStock;
		}

		public void setQuantityInStock() {
			this.quantityInStock -= 1;
		}

		public Products(String productID, String productName, Double price, int quantityInStock) {
			super();
			this.productID = productID;
			this.productName = productName;
			this.price = price;
			this.quantityInStock = quantityInStock;
		}

		@Override
		public String toString() {
			return "Product [productID=" + productID + ", productName=" + productName + ", price=" + price
					+ ", quantityInStock=" + quantityInStock + "]";
		}
		
}

