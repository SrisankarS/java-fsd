package com.project.SportyShoesPhase3.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "userdetails")
@Table(name="userdetails")
public class UserDetails extends BaseEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public long userId;
	public String username;
	@Column(name="email")
	public String emailId;
	@Column(name="phoneno")
	public String phone;
	@Column(name="productpurchased")
	public String productPurchased;
	@Column(name="purchasedate")
	public Date purchaseDate;
	public String category;
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDetails(long userId, String username, String emailId, String phone, String productPerchased,
			Date perchaseDate, String category) {
		super();
		this.userId = userId;
		this.username = username;
		this.emailId = emailId;
		this.phone = phone;
		this.productPurchased = productPerchased;
		this.purchaseDate = perchaseDate;
		this.category = category;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProductPerchased() {
		return productPurchased;
	}
	public void setProductPerchased(String productPerchased) {
		this.productPurchased = productPerchased;
	}
	public Date getPerchaseDate() {
		return purchaseDate;
	}
	public void setPerchaseDate(Date perchaseDate) {
		this.purchaseDate = perchaseDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", username=" + username + ", emailId=" + emailId + ", phone=" + phone
				+ ", productPerchased=" + productPurchased + ", perchaseDate=" + purchaseDate + ", category=" + category
				+ "]";
	}
	

}
