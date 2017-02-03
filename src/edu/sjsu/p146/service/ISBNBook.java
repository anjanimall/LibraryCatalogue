package edu.sjsu.p146.service;

public class ISBNBook {
    private int ref;
    private String isbn;
    
    ISBNBook() {
        ref = 0;
        isbn = "";
    }
    
    /**
    * gets the reference
    * @return reference
    */
    public int getRef() {
        return ref;
    }
    
    /**
     * gets the ISBN
     * @return the ISBN
     */
    public int getISBN() {
        return Integer.parseInt(isbn);
    }
    
    /**
     * sets the reference to original list
     * @param ref
     */
    public void setRef(int ref) {
        this.ref = ref;
    }
    
    /**
     * sets the ISBN
     * @param isbn
     */
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }
}