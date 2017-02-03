package edu.sjsu.p146.service;

import java.util.List;

public class LoginService {
	
	private UserService userService; //Object UserService
	
	public LoginService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * method that checks if user can login by checking if the username and password match
	 * @param username the username of the user
	 * @param password the password of the user
	 * @return true if login is successful, false if login is not successful (username and password do not match)
	 */
	public boolean loginUser(String username, String password) {
		List<User> users = this.userService.readUsersFromFile(); //reads the List users
		
		//checks if username and password match
		boolean loginSuccessful = false;
		for(User user : users) {
			if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
				loginSuccessful = true;
				break;
			}
		}
		return loginSuccessful;		
	}
}
