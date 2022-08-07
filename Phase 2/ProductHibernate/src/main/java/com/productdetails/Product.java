package com.productdetails;

public class Product {
	private int productId;
	private String productName;
	private String productOwner;
	private int quantity;
	
	
	public Product() {
	}
	
	public Product(String productName, String productOwner, int quantity) {
		this.productName = productName;
		this.productOwner = productOwner;
		this.quantity = quantity;
	}
	
	public Product(int productId, String productName, String productOwner, int quantity) {
		this.productId = productId;
		this.productName = productName;
		this.productOwner = productOwner;
		this.quantity = quantity;
	}
	
	

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductOwner() {
		return productOwner;
	}
	public void setProductOwner(String productOwner) {
		this.productOwner = productOwner;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return productId +"  "+ productName +"  "+ productOwner +"  "+ quantity;
	}
	
	
}
