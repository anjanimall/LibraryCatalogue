# eBook Library System Web Application

The goal for this project is to create an eBook library system in which a user can search through a database of books. The web application will provide the following functionalities: register, login, search, access user account, and log out. The search will have various sort methods, which will sort the books based on different criteria, such as title, author, or ISBN. 

The eBook Library System Web Application that was implemented allows a user to either login or register, then search for a list of ebooks, and check out or return the ebooks.  The actions/pages that were created were login, register, search, search results, and an account page that allow the user to navigate through the web application. The user must first begin by registering. If the user tries to log in without registering, it will show a message that login failed, prompting the user to create an account. After the user has registered and logged in, the user can then access the search page of our application. The user can then search for a specific book by submitting a title, author name, or ISBN number. In the case of a title being entered, a search and sort method were implemented to display the titles of the books based on relevance to the users’ input. If the user was to search by author, the list of authors that correspond to the input would be displayed in a list, according to the relevance of the users’ input. Lastly, if the user was to put in an ISBN number, the application would search through the list and find the corresponding ISBN number, since it is unique for every book, and display it on the screen. Various sorting algorithms were implemented, such as mergesort, quicksort, shellsort, and binary search to filter the list of books. To test our algorithms, a text file was created with a series of books that have a title, author, and ISBN number. Furthermore, a hash map and separate chaining were implemented to save the books that the user checks out to their account, which they can view by clicking on the “My Account” button. From there, the user has the option of returning a book they’ve checked out, continue searching, or logging out.
