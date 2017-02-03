package edu.sjsu.p146.service;

/**
 * Stores either the last names of authors with similar first names or stores
 * titles by the same author
 */
public class AuthorBook {
	private int ref;
	private String lastName;
	private String title;

	AuthorBook() {
		ref = 0;
		lastName = "";
		title = "";
	}

	/**
	 * gets the reference
	 * @return ref
	 */
	public int getRef() {
		return ref;
	}

	/**
	 * gets the last name 
	 * @return lastName
	 */

	public String getLastName() {
		return lastName;
	}

	/**
	 * gets the title
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * sets the reference
	 * @param ref
	 */
	public void setRef(int ref) {
		this.ref = ref;
	}

	/**
	 * sets the lastName
	 * @param lastName
	 */

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * sets the title
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
