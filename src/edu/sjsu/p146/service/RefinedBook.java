package edu.sjsu.p146.service;

public class RefinedBook {
	private int index;
	private int ref;

	RefinedBook() {
		index = 0;
		ref = 0;
	}

	/**
	 * sets the index
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * sets the reference
	 * @param ref
	 */
	public void setRef(int ref) {
		this.ref = ref;
	}

	/**
	 * gets the index
	 * @return index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * gets the reference
	 * @return the reference
	 */
	public int getRef() {
		return ref;
	}
}