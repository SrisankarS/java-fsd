package com.project.SportyShoesPhase3.entity;

public class Signup {

	private Long id;
    private String username;
    private String password;
    private String confirmPassword;
    
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setconfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Signup(Long id, String username, String password, String confirmPassword) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public Signup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Signup(Long id, String username, String password) {
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
		return "Signup [id=" + id + ", username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ "]";
	}
    
	
	
}