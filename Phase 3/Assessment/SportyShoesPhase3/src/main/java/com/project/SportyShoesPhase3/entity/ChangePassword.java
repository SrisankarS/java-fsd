package com.project.SportyShoesPhase3.entity;

public class ChangePassword {

	private Long id;
    private String username;
    private String password;
    private String newPassword;
    
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public ChangePassword(Long id, String username, String password, String newPassword) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.newPassword = newPassword;
	}
	public ChangePassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChangePassword(Long id, String username) {
		super();
		this.id = id;
		this.username = username;
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
		return "ChangePassword [id=" + id + ", username=" + username + ", password=" + password + ", newPassword=" + newPassword
				+ "]";
	}
    
	
	
}