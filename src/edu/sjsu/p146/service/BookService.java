package edu.sjsu.p146.service;

import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import edu.sjsu.p146.util.FileUtil;

public class BookService {
	
	private List<Book> books;
	private String filePath;
	private Map<String, List<Book>> checkedOutBooks;
	
	public BookService() {
		this.filePath = this.getClass().getResource("").getPath() + "books.txt"; //leads to books.txt
		this.books = this.readBooksFromFile(); //method below
		this.checkedOutBooks = new HashMap<String, List<Book>>();
	}
	
	/**
	 * sets the file path
	 * @param filePath the file path
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	/**
	 * checks if String is null and empty
	 * @param string
	 * @return true if String is null and empty, false if String is not null and empty
	 */
	private boolean isStringNullAndEmpty(String string) {
		return string == null || string.isEmpty();
	}
	
	/**
	 * checks out the book that the user selects
	 * @param username the username of the user
	 * @param isbn the isbn of the book the user selects
	 */
	public void checkout(String username, String isbn) {
		List<Book> books = this.searchISBN(isbn, this.books);
		List<Book> alreadyCheckedOut = this.checkedOutBooks.get(username);
		
		//checks if the user already checked out the book
		if(alreadyCheckedOut == null) {
			alreadyCheckedOut = new ArrayList<Book>();
			alreadyCheckedOut.add(books.get(0));
		} else {
			//check if it's already in the list, if it is, don't add
			boolean exists = false;
			for(Book book : alreadyCheckedOut) {
				if(book.getISBN().toLowerCase().equals(isbn)) {
					exists = true;
					break;
				}
			}

			if(!exists) {
				alreadyCheckedOut.add(books.get(0));
			}
		}
		
		this.checkedOutBooks.put(username, alreadyCheckedOut);
		System.out.println(this.checkedOutBooks + "Checked Out Books");
	}
	
	/**
	 * shows the list of books that the user has in their account/has checked out
	 * @param username the username of the user
	 * @return the list of the books that the user checked out
	 */
	public List<Book> booksCheckoutByUser(String username) {
		//the books checked out by the username inputted
		List<Book> checkedOut = this.checkedOutBooks.get(username);
		return checkedOut == null ? new ArrayList<Book>() : checkedOut; 
	}
	
	/**
	 * returns the book that the user selects
	 * @param username the username of the user
	 * @param isbn the isbn of the book the user wants to return
	 */
	public void returnBook(String username, String isbn) {
		List<Book> alreadyCheckedOut = this.checkedOutBooks.get(username);
		
		if(alreadyCheckedOut != null) {
			//uses an iterator and goes through the list of books
			for (ListIterator<Book> iter = alreadyCheckedOut.listIterator(); iter.hasNext(); ) {
			    Book book = iter.next();
			    if (book.getISBN().toLowerCase().equals(isbn)) {
			    	//removes the book
					iter.remove();
					break;
				}
			}
		}
		//updates the hash map
		this.checkedOutBooks.put(username, alreadyCheckedOut);
	}
	
	/**
	 * searches through the library of books
	 * @param title the title
	 * @param author the author
	 * @param isbn the ISBN
	 * @return the list of filtered/sorted books
	 */
	public List<Book> search(String title, String author, String isbn) {
		List<Book> list = this.books;
		//checks that there is an input
		if(!this.isStringNullAndEmpty(title)  
				|| !this.isStringNullAndEmpty(author) 
				|| !this.isStringNullAndEmpty(isbn)) {
			
			//ISBN input
			if(!this.isStringNullAndEmpty(isbn)) {
				list = this.searchISBN(isbn, list); //method below
				return list;
			}
			//title input
			if(!this.isStringNullAndEmpty(title)) {
				
				list = this.searchTitle(title, list); //method below
				return list;
			}
			//author input
			if(!this.isStringNullAndEmpty(author)) {
				list = this.searchAuthor(author, list); //method below
				return list;
			}
		}
		//if no input, then return the entire library by title
		List<Book> sorted = sortByTitle(list, title);
		return sorted;
	}
	
	/**
	 * search by title
	 * @param title the title
	 * @param listToFilter the list to filter
	 * @return the sort method, sorts the filtered list by title
	 */
	private List<Book> searchTitle(String title, List<Book> listToFilter) { 
		List<Book> filtered = new ArrayList<Book>();
		for(Book book : listToFilter) {
			if(book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				filtered.add(book);
			}
		}
		if(!filtered.isEmpty()) {
			return sortByTitle(filtered, title); //method below
		}
		return filtered;
	}
	
	/**
	 * search by author
	 * @param author the author
	 * @param listToFilter the list to filter
	 * @return the sort method, sorts the filtered list by author
	 */
	private List<Book> searchAuthor(String author, List<Book> listToFilter) { 
		List<Book> filtered = new ArrayList<Book>();
		
		for(Book book : listToFilter) {
			if(book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				filtered.add(book);
			}
		}
		
		return sortByAuthor(filtered, author);
	}
	
	/**
	 * search by ISBN
	 * @param isbn the ISBN
	 * @param listToFilter the list to filter
	 * @return the book with the given ISBN
	 */
	private List<Book> searchISBN(String isbn, List<Book> listToFilter) {
		List<Book> list = null;
		int isbnINT = Integer.parseInt(isbn);
		List<Book> found = new ArrayList<Book>();
		ISBNBookDB db = new ISBNBookDB(listToFilter,isbnINT);
		try {
		db.mergeSort(0,listToFilter.size()-1);
		found.add(listToFilter.get(db.binarySearch(0,listToFilter.size()-1)));
		return found;
		} catch(IndexOutOfBoundsException e) {
			return list = new ArrayList<Book>(); 
		}
	}
	
	/**
	 * sort by title
	 * @param list the filtered list
	 * @param word the word 
	 * @return the list of results
	 */
	private static List<Book> sortByTitle(List<Book> list, String word) {
		RefinedBookDB results = new RefinedBookDB(list, word);
		results.sortRef(0, list.size()-1);
		return results.returnList();
	}
	
	/**
	 * sort by author
	 * @param list the filtered list
	 * @param word the word
	 * @return the list of results
	 */
	private static List<Book> sortByAuthor(List<Book> list, String word) {
		AuthorBookDB db = new AuthorBookDB(list, word);
		db.shellSort();
		return db.returnList();
	}
	
	/**
	 * method used to register the new book, gets the information of the new book
	 * @param title the title of the new book
	 * @param author the author of the new book 
	 * @param isbn the isbn of the new book
	 * @return message that indicates if registration was successful or not successful
	 */
	public String registerBook(String title, String author, String isbn) {
		String message = "SUCCESS";

		//checks if book already exists
		boolean exists = false;
		for(Book book : this.books) { //goes through List books
			if(book.getISBN().equals(isbn)) { //checks by ISBN (easiest way of checking)
				exists = true;
				break;
			}
		}
		
		if(!exists) {
			boolean successful = this.addBook(title, author, isbn);
			if(successful) {
				message = "SUCCESS"; //successfully added to the file
			} else {
				message = "Could not write new book to file.";
			}
		} else {
			message = "ISBN" + isbn + " already exists!";
		}
		return message;
	}
	
	/**
	 * method to add the information of the new book to the text file (books.txt)
	 * @param title the title of the newly registered book
	 * @param author the author of the newly registered book
	 * @param isbn the isbn of the newly registered book
	 * @return
	 */
	private boolean addBook(String title, String author, String isbn)
	{
		boolean successful;
		Book book = new Book(title, author, isbn);
		this.books.add(book);
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(this.books); //creates a JSON String representation of the books List
		
		try {
			FileUtil.writeToFile(this.filePath, jsonData); //write the JSON String representation to the file in file pat
			successful = true; //if the book is successfully added to the file (books.txt)
		} catch (IOException e) {
			successful = false; //IOException is thrown when there is an issue with finding file (books.txt) in file path or writing to file (books.txt)
		}
		return successful;
	}
	
	/**
	 * method that uses Google Gson library to read file and deserialize the JSON String to given Object
	 * @return the List list
	 */
	private List<Book> readBooksFromFile() { 
		List<Book> list = null;
		try {
			Gson gson = new Gson();
			JsonReader jsonReader = new JsonReader(new FileReader(this.filePath));
			Book[] books = gson.fromJson(jsonReader, Book[].class);
			//if file contains nothing, books will be null
			//if books == null, create an empty list
			//if books =! null, create a list and add books to it
			list = (books == null) ? new ArrayList<Book>() : new ArrayList<Book>(Arrays.asList(books));
		} catch (IOException e) {
			list = new ArrayList<Book>(); 
			System.out.println("returning an empty list of boooks");
			System.out.println(e.getMessage());
		}
		return list;
	}

}
