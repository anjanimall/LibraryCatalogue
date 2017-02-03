package edu.sjsu.p146.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import edu.sjsu.p146.util.FileUtil;

public class UserService {
	
	private List<User> users; //instance variable for a List of the Object User named users
	private String filePath; //instance variable for a String named filePath -> leads to users.txt
	
	public UserService() {
		this.filePath = this.getClass().getResource("").getPath() + "users.txt"; //leads to users.txt
		String path = "/C:/Users/Subhanjani/Desktop/CS146/Project146/src/edu/sjsu/p146/service/users.txt";
		this.filePath = path;
		this.users = this.readUsersFromFile(); //reads the List users -> method created in this class
	}

	/**
	 * method used to register the new user, gets the information of the new user 
	 * @param firstName the first name of the new user
	 * @param lastName the last name of the new user
	 * @param username the username of the new user
	 * @param password the password of the new user
	 * @return message that indicates if registration was successful or not successful
	 * @throws IOException
	 */
	
	public String registerUser(String firstName, String lastName, String username, String password) throws IOException { //exception if file does not exist
		String message = "SUCCESS";
		
		//checks if username already exists
		boolean exists = false;
		for(User user : this.users) { //goes through the List users
			if(user.getUsername().equals(username)) {
				exists = true; 
				break;
			}
		}
		
		if(!exists) { //after going to for loop, exists = false
			boolean successful = this.addUser(firstName, lastName, username, password);
			if(successful) {
				message = "SUCCESS"; //successfully added to file
			} else {
				message = "Could not write new user to file."; 
			}
		} else { //after going to for loop, exists = true
			message = "Username " + username + " already exists!"; //prints message, does not add to file
		}
		
		return message;
	}
	
	/**
	 * method to add the information of the new user to the text file (users.txt)
	 * @param firstName the first name of the newly registered user
	 * @param lastName the last name of the newly registered user
	 * @param username the username of the newly registered user
	 * @param password the password of the newly registered user
	 * @return true if the information of the users was successfully added to the file (users.txt), false (throws exception) if the file does not exist
	 */
	private boolean addUser(String firstName, String lastName, String username, String password) {//adding user to users.txt
		boolean successful;
		User user = new User(firstName, lastName, username, password); //creating new Object
		this.users.add(user); //adding user to the List users
		
		Gson gson = new Gson(); //Gson is a library developed by Google that serializes object to JSON String and deserializes JSON String to given object
		String jsonData = gson.toJson(this.users); //creates a JSON String representation of the users List
		
		try {
			//writeToFile method in FileUtil.java
			FileUtil.writeToFile(this.filePath, jsonData); //write the JSON String representation to the file in file path 
			successful = true; //if the user is successfully added to the file (users.txt)
		} catch (IOException e) { //IOException is thrown when there is an issue with finding file (users.txt) in file path or writing to file (users.txt)
			successful = false; //did not successfully write to file (users.txt)
		}
		
		return successful;
	}
	
	/**
	 * method that uses Google Gson library to read file and deserialize the JSON String to given Object
	 * @return the List list
	 */
	public List<User> readUsersFromFile() {
		List<User> list = null; //List of the Object User named list
		try {
			Gson gson = new Gson();
			JsonReader jsonReader = new JsonReader(new FileReader(this.filePath)); //Reads the JSON data in the file in the file path 
			User[] users = gson.fromJson(jsonReader, User[].class); //deserialize JSON string to given object
			//if file contains nothing, users will be null
			//if users == null, create an empty list
			//is users != null, create a list and add users to it
			list = (users == null) ? new ArrayList<User>() : new ArrayList<User>(Arrays.asList(users));
		} catch (IOException e) { 
			list = new ArrayList<User>(); 
			System.out.println("returning an empty list of users");
			System.out.println(e.getMessage());
		}
		
		return list;
	}
}
