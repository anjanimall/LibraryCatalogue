package edu.sjsu.p146.service;

public class Book {

	//creating an Object Book with title, author, and ISBN
	//methods in this class: getTitle, getAuthor, getIsbn
	
	private String title;
	private String author;
	private String isbn;

	public Book(String title, String author, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getISBN() {
		return isbn;
	}
}
