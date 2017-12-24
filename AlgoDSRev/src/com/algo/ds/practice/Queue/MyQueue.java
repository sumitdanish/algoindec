package com.algo.ds.practice.Queue;

public class MyQueue {

	private int data;
	private MyQueue front;
	private MyQueue rear;
	private MyQueue next;
	private MyQueue previous;

	public MyQueue() {

	}

	public MyQueue(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public MyQueue getFront() {
		return front;
	}

	public void setFront(MyQueue front) {
		this.front = front;
	}

	public MyQueue getRear() {
		return rear;
	}

	public void setRear(MyQueue rear) {
		this.rear = rear;
	}

	public MyQueue getNext() {
		return next;
	}

	public void setNext(MyQueue next) {
		this.next = next;
	}

	public MyQueue getPrevious() {
		return previous;
	}

	public void setPrevious(MyQueue previous) {
		this.previous = previous;
	}

}
