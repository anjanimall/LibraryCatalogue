package edu.sjsu.p146.service;

import java.util.ArrayList;
import java.util.List;

/**
 * allows a search and sort for either just the first name or the full first and last name
 */
public class AuthorBookDB {
    AuthorBook[] db;
    List<Book>list;
    String authorN;
    
    AuthorBookDB(List<Book> list, String authorName){
        db = new AuthorBook[list.size()];
        this.list = list;
        authorN = authorName.toLowerCase();
            if(authorName.contains(" ")){ //If the search is for a first and last name, add the title
                for(int i = 0; i < list.size(); i++){
                    if(list.get(i).getAuthor().contains(authorName)){
                db[i] = new AuthorBook();
                db[i].setRef(i);
                db[i].setTitle((list.get(i).getTitle().toLowerCase())); //Set the title
                    }
             }
            }else{
            for(int i = 0; i < list.size(); i++){ //Search just for first name
                db[i] = new AuthorBook();
                db[i].setRef(i);
                //grabs the authors last name
                db[i].setLastName((list.get(i).getAuthor().toLowerCase().substring(authorName.length())));
            }
       }
    }
    
    public void shellSort(){
        int inner, outer;
        AuthorBook temp;
        
        if(authorN.contains(" ")){
            shellSortTitle(); //sort the titles if the search was for a full author name
        } else { //else sort the last names 
        int h = 1;
        while (h <= db.length / 3) {
            h = h * 3 + 1;
        }
        
        while (h > 0) {
            for (outer = h; outer < db.length; outer++) {
                temp = db[outer];
                inner = outer;
 
             while (inner > h - 1 && (db[inner - h].getLastName().compareTo(temp.getLastName()) > 0)){
                db[inner] = db[inner - h];
                inner -= h;
             }
                 db[inner] = temp;
            }
             h = (h - 1) / 3;
            }
        }
    }
    
     private void shellSortTitle(){
        int inner, outer;
        AuthorBook temp = new AuthorBook();
 
        int h = 1;
        while (h <= db.length / 3) {
            h = h * 3 + 1;
        }
        
        while (h > 0) {
            for (outer = h; outer < db.length; outer++) {
                temp = db[outer];
                inner = outer;
 
             while (inner > h - 1 && (db[inner - h].getTitle().compareTo(temp.getTitle()) > 0)){
                db[inner] = db[inner - h];
                inner -= h;
             }
                 db[inner] = temp;
            }
             h = (h - 1) / 3;
            }
        }
    
    /**
     * prints list to console
     */
    public void printList(){
        for(int i = 0; i < db.length; i++){
            db[i].getTitle();         
        }
        System.out.println();
    }
    
    /**
     * prints references
     */
    public void printRef(){
        for(AuthorBook b: db){
            System.out.println(b.getRef());
        }
        
        System.out.println();
    }
    
    /**
     * returns new sorted list
     * @return the list
     */
    public List<Book> returnList(){
        List<Book> newList = new ArrayList();
    	for(AuthorBook book: db){
    		newList.add(list.get(book.getRef()));
    	}
    	return newList;
    }
}
