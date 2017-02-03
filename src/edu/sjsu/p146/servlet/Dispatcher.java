package edu.sjsu.p146.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sjsu.p146.service.Book;
import edu.sjsu.p146.service.BookService;
import edu.sjsu.p146.service.LoginService;
import edu.sjsu.p146.service.UserService;

/**
 * Servlet implementation class Dispatcher
 */

@WebServlet("/Dispatcher")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private BookService bookService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dispatcher() {
		super();
		this.userService = new UserService();
		this.bookService = new BookService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String url = request.getServletPath();
		String path = "";
		System.out.println("URL : " + url);

		if (url.equals("/") || url.equals("/logout.do")) { 
			//leads to the login page
			path = "WEB-INF/jsps/login.jsp"; 

		} else if (url.equals("/login.do")) {
			LoginService loginService = new LoginService(this.userService); 
			//gets the username that the user inputs
			String username = request.getParameter("username");
			//gets the password that the user inputs
			String password = request.getParameter("password"); 
			String msg = "";

			if (loginService.loginUser(username, password)) {
				msg = "Successfully Logged In";
				//leads to search page if login is successful
				path = "WEB-INF/jsps/search.jsp";

			} else {
				msg = "LOGIN FAILED";
				//leads to the login page if login is unsuccessful
				path = "WEB-INF/jsps/login.jsp";

			}
			request.setAttribute("message", msg);
			request.setAttribute("username", username);

		} else if (url.equals("/registerPage.do")) {
			//leads to the register page if user clicks on register
			path = "WEB-INF/jsps/register.jsp";

		} else if (url.equals("/search.do")) {
			//gets the username
			String username = request.getParameter("username");
			request.setAttribute("username", username);
			//leads to the search page
			path = "WEB-INF/jsps/search.jsp"; 
			
		} else if (url.equals("/register.do")) {
			//gets the first name that the user inputs
			String firstName = request.getParameter("firstName"); 
			//gets the last name that the user inputs
			String lastName = request.getParameter("lastName");
			//gets the username that the user inputs
			String username = request.getParameter("username");
			//gets the password that the user inputs
			String password = request.getParameter("password");
			//calls registerUser method in userService class
			String message = this.userService.registerUser(firstName, lastName, username, password);

			if (message.equals("SUCCESS")) {
				//if registration is successful, leads to the search page
				path = "WEB-INF/jsps/search.jsp";
			} else {
				//if registration is unsuccessful, leads to the register page
				path = "WEB-INF/jsps/register.jsp";
				request.setAttribute("message", message); 
			}

		} else if (url.equals("/searchresults.do")) {

			//gets the title that the user inputs
			String title = request.getParameter("title"); 
			//gets the author that the user inputs
			String author = request.getParameter("author");
			//gets the ISBN that the user inputs
			String isbn = request.getParameter("isbn");
			//gets the username that the user inputs
			String username = request.getParameter("username");
			//calls search method in bookService class
			List<Book> books = this.bookService.search(title, author, isbn); 

			request.setAttribute("books", (Book[]) books.toArray(new Book[books.size()]));
			request.setAttribute("username", username);
			
			//leads to the search results page
			path = "WEB-INF/jsps/library.jsp";

		} else if (url.equals("/account.do")) {
			//gets the username that the user inputs
			String username = request.getParameter("username");
			//gets the ISBN that the user inputs
			String isbn = request.getParameter("isbn");
			//gets the action that the user inputs
			String action = request.getParameter("action");
			request.setAttribute("username", username);

			if (isbn != null) {
				if (action.equals("checkout")) {
					//if user presses "checkout" calls checkout method in bookService
					this.bookService.checkout(username, isbn);
				} else if (action.equals("return")) {
					//if user presses "return" calls returnBook method in bookService
					this.bookService.returnBook(username, isbn);
				}
			}

			List<Book> books = this.bookService.booksCheckoutByUser(username);
			request.setAttribute("books", (Book[]) books.toArray(new Book[books.size()]));

			//leads to the account page
			path = "WEB-INF/jsps/account.jsp";
		}

		System.out.println("Path" + path);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
