package com.algo.ds.practice.Stack;

public class DesignStack {

	/*
	 * Design a stack with operations on middle element How to implement a stack
	 * which will support following operations in O(1) time complexity? 1)
	 * push() which adds an element to the top of stack. 2) pop() which removes
	 * an element from top of stack. 3) findMiddle() which will return middle
	 * element of the stack. 4) deleteMiddle() which will delete the middle
	 * element.
	 */
	static MyStack ms;

	public static void main(String[] args) {

		try {
			ms = new MyStack();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void push(int data) {
		try {
			DLLNode dll = new DLLNode(data);
			dll.pre = null;
			dll.next = ms.head;
			ms.count++;
			if (ms.count == 1) {
				ms.mid = dll;
			} else {
				ms.head.pre = dll;
				if (ms.count != 0 && ms.count > 1) {
					ms.mid = ms.mid.pre;
				}
			}
			ms.head = dll;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

class MyStack {
	public DLLNode head;
	public DLLNode mid;
	public int count = 0;

	public MyStack() {
		count = 0;
	}

}

class DLLNode {
	public DLLNode next;
	public DLLNode pre;
	public int data;

	public DLLNode(int data) {
		this.data = data;
	}
}