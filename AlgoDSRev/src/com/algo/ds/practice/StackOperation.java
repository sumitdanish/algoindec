package com.algo.ds.practice;

import java.io.File;
import java.util.Scanner;

public class StackOperation {

	/**
	 * @param args
	 */

	static MyStack stack;
	int size = 0;

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("stack.txt"));
			String[] a = sc.next().split(",");
			StackOperation myStack = new StackOperation();
			for (String s : a) {
				myStack.push(Integer.parseInt(s));
			}

			int d = myStack.pop();

			System.out.println(d);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int getSize(MyStack stack) {
		try {
			return stack.getSize();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int pop() {
		try {
			if (stack == null) {
				System.out.println("Stack Is Empty");
				return Integer.MIN_VALUE;
			}
			int len = stack.getSize();
			stack.setSize(len--);
			MyStack st = stack;
			stack = stack.getNext();
			return st.getData();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void push(int data) {
		try {
			MyStack st = new MyStack(data, size + 1);
			if (stack == null) {
				stack = st;
			} else {
				size = stack.getSize();
				st.setNext(stack);
				stack = st;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
