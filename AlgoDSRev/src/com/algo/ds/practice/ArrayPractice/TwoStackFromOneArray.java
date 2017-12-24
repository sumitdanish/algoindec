package com.algo.ds.practice.ArrayPractice;

public class TwoStackFromOneArray {

	/**
	 * @param args
	 */

	static int[] a;
	static int top1 = 0;
	static int top2 = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			a = new int[10];
			top1 = -1;
			top2 = a.length;
			TwoStackFromOneArray stack = new TwoStackFromOneArray();
			stack.push1(5);
			stack.push1(10);
			stack.push1(15);
			stack.push2(11);
			stack.push2(7);
			stack.push2(17);

			int val1 = stack.pop1();
			int val2 = stack.pop2();

			System.out.println(val1 + " > " + val2);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void push1(int val) {
		try {
			if (top1 < top2 - 1) {
				top1++;
				a[top1] = val;
			} else {
				System.out.println("Stack one is overflow");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void push2(int val) {
		try {
			if (top1 < top2 - 1) {
				top2--;
				a[top2] = val;
			} else {
				System.out.println("Stack one is overflow");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private int pop1() {
		try {
			if (top1 < 0) {
				System.out.println("Stack is empty");
				return -1;
			}
			int val = a[top1--];
			return val;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

	private int pop2() {
		try {
			if (top2 > a.length - 1) {
				System.out.println("Stack is empty");
				return -1;
			}
			int val = a[top2++];
			return val;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return -1;
	}

}
