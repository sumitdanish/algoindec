package com.algo.ds.practice.Stack;

public class O1Stack {

	private int top = 0;
	private int[] sa;
	private int maxSize;

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int[] getSa() {
		return sa;
	}

	public void setSa(int[] sa) {
		this.sa = sa;
	}

	public O1Stack(int top, int maxSize) {
		this.top = top;
		this.maxSize = maxSize;
		sa = new int[maxSize];
	}

	public void push(int val) {
		try {
			if (isEmpty()) {
				System.out.println("Stack is full !");
			}
			top++;
			sa[top] = val;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int getPop() {
		try {
			int val = sa[top--];
			return val;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	public boolean isEmpty() {
		try {
			if (getTop() == maxSize) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
