package edu.sjsu.p146.service;

import java.util.List;

/**
 * sorts and stores references of passed list to find ISBN
 */
public class ISBNBookDB {
	ISBNBook[] tempArray; // For mergesort
	ISBNBook[] db;
	List<Book> list; // Copy of original book list
	int targetISBN; // For binary search

	ISBNBookDB(List<Book> list, int targetISBN) {
		this.list = list;
		this.targetISBN = targetISBN;
		tempArray = new ISBNBook[list.size()];
		db = new ISBNBook[list.size()];
		for (int i = 0; i < list.size(); i++) {
			db[i] = new ISBNBook();
			db[i].setISBN(list.get(i).getISBN()); //grab ISBN of every book
			db[i].setRef(i); //keep note of where in the list the ISBN is grabbed from
		}
	}

	/**
	 * mergesorts the ISBN in order to perform a binary search
	 * @param low
	 * @param high
	 */
	public void mergeSort(int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;

			mergeSort(low, middle);
			mergeSort(middle + 1, high);
			mergeParts(low, middle, high);
		}
	}

	private void mergeParts(int low, int middle, int high) {

		for (int i = low; i <= high; i++) {
			tempArray[i] = db[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;

		while (i <= middle && j <= high) {
			if (tempArray[i].getISBN() <= tempArray[j].getISBN()) {
				db[k] = tempArray[i];
				i++;
			} else {
				db[k] = tempArray[j];
				j++;
			}
			k++;
		}

		while (i <= middle) {
			db[k] = tempArray[i];
			k++;
			i++;
		}
	}

	/**
	 * prints out Sorted list to console
	 */
	public void printList() {
		for (ISBNBook b : db) {
			System.out.println(b.getISBN());
		}
	}

	/**
	 * prints out the references
	 */
	public void printRef() {
		for (ISBNBook b : db) {
			System.out.println(b.getRef());
		}
	}

	/**
	 * binary Search to find target ISBN
	 * @param left
	 * @param right
	 * @return recursive method, an int
	 */
	public int binarySearch(int left, int right) { //requires sorted ISBNs
		if (left > right) {
			return -1;
		}
		int middle = (left + right) / 2;

		if (db[middle].getISBN() == targetISBN) {
			return db[middle].getRef();
		} else if (db[middle].getISBN() > targetISBN) {
			return binarySearch(left, middle - 1);
		} else {
			return binarySearch(middle + 1, right);
		}
	}
}
