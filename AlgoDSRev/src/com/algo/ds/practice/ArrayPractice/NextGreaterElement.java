package com.algo.ds.practice.ArrayPractice;

public class NextGreaterElement {

	/**
	 * @param args
	 */

	static int[] stack;
	static int top = -1;
	static int size = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int[] a = { 4, 5, 2, 25 };
			stack = new int[a.length];
			size = a.length;
			new NextGreaterElement().nextGreaterElement(a);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void nextGreaterElement(int[] a) {
		try {
			int ele = 0;
			int next = 0;
			for (int i = 0; i < a.length; i++) {
				next = a[i];
				if (!isEmpty()) {
					ele = pop();
					while (ele < next) {
						System.out.println("Element > " + ele + " > next > "
								+ next);
						if (isEmpty()) {
							break;
						}
						ele = pop();
					}
					if (ele > next) {
						push(ele);
					}
				}
				push(next);
			}
			while (!isEmpty()) {
				next = -1;
				System.out.println(pop() + " > " + next);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void push(int val) {
		try {
			if (top == size) {
				System.out.println("Its Full...");
			}
			top++;
			stack[top] = val;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int pop() {
		try {
			if (top == -1) {
				System.out.println("EMpty...");
			}
			int val = stack[top--];
			return val;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private boolean isEmpty() {
		try {
			return top == -1 ? true : false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

}
