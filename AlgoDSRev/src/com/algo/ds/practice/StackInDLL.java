package com.algo.ds.practice;

public class StackInDLL {

	/**
	 * @param args
	 */

	static MyStackInDLL st;

	public static void main(String[] args) {

		try {
			st = new MyStackInDLL();
			StackInDLL stac = new StackInDLL();
			stac.push(12);
			stac.push(13);
			stac.push(14);
			stac.push(15);
			stac.push(16);

			// System.out.println(st.mid.next.data);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void push(int data) {
		try {
			StackInDLLNode stack = new StackInDLLNode(data);
			if (st.head == null) {
				st.head = stack;
				st.count++;
				st.mid = stack;
			} else {
				stack.next = st.head;
				st.head.pre = stack;
				st.count++;
				if (st.count % 2 != 0 && st.count > 1) {
					st.mid = st.mid.pre;
				}
				st.head = stack;

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int pop() {
		try {
			StackInDLLNode s = st.head;
			st.head = st.head.next;
			st.mid = st.mid.next;
			st.count--;
			return s.data;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int getMindelement() {
		try {
			int mid = st.mid.data;
			return mid;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void deleteMid() {
		try {
			int data = st.mid.data;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

class MyStackInDLL {
	public StackInDLLNode head;
	public StackInDLLNode mid;
	public int count = 0;

	public MyStackInDLL() {
		count = 0;
	}

}

class StackInDLLNode {
	public StackInDLLNode next;
	public StackInDLLNode pre;
	public int data;

	public StackInDLLNode(int data) {
		this.data = data;
	}
}