package edu.sjsu.p146.service;

import java.util.List;
import java.util.ArrayList;

public class RefinedBookDB {
	RefinedBook[] db;
	List<Book> list;

	RefinedBookDB(List<Book> list, String word) {

		db = new RefinedBook[list.size()];
		this.list = list;
		for (int i = 0; i < list.size(); i++) {
			db[i] = new RefinedBook();
			// Save where the book is in the original list
			db[i].setRef(i);
			// In the title of each book, find the first instance of the word
			// and note it's index
			int x = list.get(i).getTitle().toLowerCase().indexOf(word);
			db[i].setIndex(x);
		}
	}

	/**
	 * Quick Sort the array according to the index of the first occurrence of keyword
	 * @param low
	 * @param high
	 */
	public void sortRef(int low, int high) {
		int i = low;
		int j = high;

		int pivot = db[(low + high) / 2].getIndex();

		while (i <= j) {

			while (db[i].getIndex() < pivot) {
				i++;
			}
			while (db[j].getIndex() > pivot) {
				j--;
			}
			if (i <= j) {
				RefinedBook temp = db[i];
				db[i] = db[j];
				db[j] = temp;
				i++;
				j--;
			}
		}

		if (low < j) {
			sortRef(low, j);
		}
		if (i < high) {
			sortRef(i, high);
		}
	}

	/**
	 * print out the indexes
	 */
	public void printIndex() {
		for (RefinedBook b : db) {
			System.out.print(b.getIndex() + " ");
		}
		System.out.println();
	}

	/**
	 * print the references
	 */
	public void printRef() {
		for (RefinedBook b : db) {
			System.out.print(b.getRef() + " ");
		}

		System.out.println();
	}

	/**
	 * returns a list of sorted books using the reference of the original list to return the actual Book
	 * @return a list of sorted books
	 */
	public List<Book> returnList() {
		List<Book> newList = new ArrayList();
		for (RefinedBook book : db) {
			newList.add(list.get(book.getRef()));
		}
		return newList;
	}

}
