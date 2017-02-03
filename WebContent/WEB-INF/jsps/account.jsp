<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MY ACCOUNT</title>
</head>
<body style="background-color: black; font-color: white">
	<h1 align="center"
		style="font-family: 'Verdana', sans-serif; color: white;">MY
		ACCOUNT</h1>
	<br></br>
	<table border="2" align="center"
		style="font-family: 'Verdana', sans-serif; color: white;">
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>ISBN</th>
			<th>Return?</th>
		</tr>
		<%
			String message = (String) request.getAttribute("message");
			String username = (String) request.getAttribute("username");
			String password = (String) request.getAttribute("password");
			edu.sjsu.p146.service.Book[] books = (edu.sjsu.p146.service.Book[]) request
					.getAttribute("books");

			for (edu.sjsu.p146.service.Book book : books) {
		%>
		<tr>
			<td><%=book.getTitle()%></td>
			<td><%=book.getAuthor()%></td>
			<td><%=book.getISBN()%></td>
			<td><a href="/Project146/account.do?isbn=<%=book.getISBN()%>&username=<%=username%>&action=return">Return</a></td>
		</tr>
		<%
			}
		%>

	</table>
	<br></br>
	<center>
		<a href="./search.do?username=<%=username%>">SEARCH</a>
	</center>
	<center>
		<a href="./logout.do" class="exit-btn exit-btn-2">LOG OUT</a>
	</center>
</body>
</html>