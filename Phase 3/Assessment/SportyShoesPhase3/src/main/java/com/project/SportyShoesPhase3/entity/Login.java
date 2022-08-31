package com.project.SportyShoesPhase3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userlogin")
public class Login {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long id;
	@Column(name= "name")
    private String username;
    private String password;
    
	public Login(Long id, String username, String password, String newPassword) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(Signup signupUser) {
		super();
		this.username = signupUser.getUsername();
		this.password = signupUser.getPassword();
	}
	public Login(ChangePassword changePassword) {
		super();
		this.id = changePassword.getId();
		this.username = changePassword.getUsername();
		this.password = changePassword.getNewPassword();
	}
	public Login(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
    
	
	
}