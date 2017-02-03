package edu.sjsu.p146.service;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	//creating an Object User with first name, last name, username, and password
	//methods in this class: getFirstName, getLastName, getUsername, getPassword

	private String firstName;
	private String lastName;
	private String username;
	private String password;

	public User(String firstName, String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
