package edu.sjsu.p146.load;

import edu.sjsu.p146.service.BookService;

public class LoadBooks {

	public static void main(String[] args) {

		BookService bookService = new BookService();
		bookService.setFilePath("/C:/Users/Subhanjani/Desktop/CS146/Project146/src/edu/sjsu/p146/service/books.txt");
		
		System.out.println(bookService.registerBook("The Great Gatsby", "F. Scott Fitzgerald", "1234567890"));
		System.out.println(bookService.registerBook("Twilight", "Stephenie Meyer", "1234567891"));
		System.out.println(bookService.registerBook("Slaughterhouse-Five", "Kurt Vonnegut", "1234567892"));
		System.out.println(bookService.registerBook("The Fault in Our Stars", "John Green", "1234567893")); //author - john
		System.out.println(bookService.registerBook("Dear John", "Nicholas Sparks", "1234567894"));
		System.out.println(bookService.registerBook("The Catcher in the Rye", "JD Salinger", "1234567895")); //title - catch
		System.out.println(bookService.registerBook("Catch-22", "Joseph Heller", "1234567896")); //title - catch
		System.out.println(bookService.registerBook("Divergent", "Veronica Roth", "1234567897"));
		System.out.println(bookService.registerBook("Insurgent", "Veronica Roth", "1234567898")); 
		System.out.println(bookService.registerBook("Allegiant", "Veronica Roth", "1234567899")); 
		System.out.println(bookService.registerBook("The Titans", "John Jakes", "1234567867")); //author - john
		System.out.println(bookService.registerBook("Call the New World", "John Edward Jennings", "1234567868")); //author - john
		System.out.println(bookService.registerBook("1984", "George Orwell", "1234567880"));
		System.out.println(bookService.registerBook("Frankenstein", "Mary Shelley", "1234567881"));
		System.out.println(bookService.registerBook("Eragon", "Christopher Paolini", "1234567882"));
		System.out.println(bookService.registerBook("Harry Potter and the Sorcerers Stone", "JK Rowling", "1234567883"));
		System.out.println(bookService.registerBook("Harry Potter and the Chamber of Secrets", "JK Rowling", "1234567884"));
		System.out.println(bookService.registerBook("Harry Potter and the Prisoner of Azkaban", "JK Rowling", "1234567885"));
		System.out.println(bookService.registerBook("Harry Potter and the Goblet of Fire", "JK Rowling", "1234567886"));
		System.out.println(bookService.registerBook("Harry Potter and the Order of the Pheonix", "JK Rowling", "1234567887"));
		System.out.println(bookService.registerBook("Harry Potter and the Half Blood Prince", "JK Rowling", "1234567888"));
		System.out.println(bookService.registerBook("Harry Potter and the Deathly Hallows", "JK Rowling", "1234567889"));
		System.out.println(bookService.registerBook("To Kill A Mockingbird", "Harper Lee", "1234567870"));
		System.out.println(bookService.registerBook("Huckleberry Finn", "Mark Twain", "1234567871"));
		System.out.println(bookService.registerBook("Lord of the Flies", "William Golding", "1234567872"));
		System.out.println(bookService.registerBook("The Scarlet Letter", "Nathaniel Hawthorne", "1234567873"));
		System.out.println(bookService.registerBook("Alice in Wonderland", "Lewis Carroll", "1234567874"));
		System.out.println(bookService.registerBook("Jurassic Park", "Michael Crichton", "1234567875"));
		System.out.println(bookService.registerBook("The Time Machine", "HG Wells", "1234567876"));
		System.out.println(bookService.registerBook("Lolita", "Vladimir Nabokov", "1234567877"));
		System.out.println(bookService.registerBook("Emma", "Jane Austen", "1234567878"));
		System.out.println(bookService.registerBook("Moby Dick", "Herman Melville", "1234567879"));
		System.out.println(bookService.registerBook("The Spirit Catches You and You Fall Down", "Anne Fadiman", "1234567860")); //title - catch
		System.out.println(bookService.registerBook("The Hunger Games", "Suzanne Collins", "1234567861"));
		System.out.println(bookService.registerBook("Catching Fire", "Suzanne Collins", "1234567862")); //title - catch
		System.out.println(bookService.registerBook("Mockingjay", "Suzanne Collins", "1234567863"));
		System.out.println(bookService.registerBook("Catch Me", "Lisa Gardner", "1234567864")); //title - catch
		System.out.println(bookService.registerBook("Rimefire", "William W. Johnstone", "1234567865")); //author - john
		System.out.println(bookService.registerBook("Of Mice and Men", "John Steinbeck", "1234567866")); //author - john
		
	}
}
