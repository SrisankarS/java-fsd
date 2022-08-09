package com.jsp;

public class Product {
	private int productid;
	private String pname;
	private String powner;
	private String quantity;
	
	public Product() {
		
	}
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPowner() {
		return powner;
	}
	public void setPowner(String powner) {
		this.powner = powner;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
}
