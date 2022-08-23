package com.project.UserAuthentication.exceptions;

public class UserNotFoundException extends RuntimeException {
	 public UserNotFoundException(String string) {
		super(string);
	}

	public UserNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
}
