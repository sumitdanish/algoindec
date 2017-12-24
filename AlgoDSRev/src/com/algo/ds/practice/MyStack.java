package com.algo.ds.practice;

public class MyStack {

	private int data;
	private MyStack next;
	private int size;

	public MyStack(int data, int size) {
		super();
		this.data = data;
		this.size = size;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public MyStack getNext() {
		return next;
	}

	public void setNext(MyStack next) {
		this.next = next;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
