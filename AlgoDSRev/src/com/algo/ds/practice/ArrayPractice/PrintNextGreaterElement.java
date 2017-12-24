package com.algo.ds.practice.ArrayPractice;

public class PrintNextGreaterElement {

	/**
	 * @param args
	 */
	static int[] st = new int[10];
	static int top = -1;

	public static void main(String[] args) {

		try {
			int[] a = { 11, 13, 21, 3 };
			new PrintNextGreaterElement().printGreatestELement(a);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private int pop() {
		try {
			if (top == -1) {
				return Integer.MIN_VALUE;
			}
			int d = st[top--];
			return d;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private void push(int data) {
		try {
			if (top == 10) {
				System.out.println("Stack is full");
				return;
			}
			top++;
			st[top] = data;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private boolean isEmpty() {
		try {
			return top == -1 ? true : false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	private void printGreatestELement(int[] a) {
		try {
			int next = 0;
			push(a[0]);
			int ele = 0;
			for (int i = 1; i < a.length; i++) {
				next = a[i];
				if (!isEmpty()) {
					ele = pop();
					while (ele < next) {
						System.out.println("ELement > " + ele
								+ " Greatest ELement > " + next);
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

}
