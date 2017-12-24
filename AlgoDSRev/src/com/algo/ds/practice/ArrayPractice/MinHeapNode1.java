package com.algo.ds.practice.ArrayPractice;

/*
 * 
 * Print all elements in sorted order from row and column wise sorted matrix
 * 
 * 
 * */

public class MinHeapNode1 {

	public int i;
	public int j;
	public int element;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public MinHeapNode1(int i, int j, int element) {
		super();
		this.i = i;
		this.j = j;
		this.element = element;
	}

	public MinHeapNode1(int i, int element) {
		super();
		this.i = i;
		this.element = element;
	}

}
